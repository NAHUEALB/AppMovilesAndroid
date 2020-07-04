package com.example.ageofempires.ui.calculadora;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.R;


import java.io.File;
import java.io.FileOutputStream;

public class CalculadoraFragment  extends Fragment {

    EditText comidaET;
    EditText oroET;
    EditText maderaET;
    LinearLayout dialogShare;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_calculadora, container,false);

        Button btn_calcu = root.findViewById(R.id.btn_calcular);
        comidaET = root.findViewById(R.id.comida_num);

        oroET = root.findViewById(R.id.oro_num);

        maderaET = root.findViewById(R.id.madera_num);

        btn_calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numC = Integer.parseInt(comidaET.getText().toString()) + 1;
                Integer numO = Integer.parseInt(oroET.getText().toString()) + 1;
                Integer numM = Integer.parseInt(maderaET.getText().toString()) + 1;


                //Brillo

                // valores constantes para una unidad unica generica
                int uuc=40; int uuo=50; int uum=0; int uud=4;

                float[][] matriz = inicializarSimplex(numC, numO, numM, uuc, uuo, uum, uud);
                int[] vars = new int[3];
                for (int i=0; i<=2; i++) {
                    vars[i] = 0;
                }
                imprimirSimplex(matriz, vars);
                matriz = calcularSimplex(matriz, vars);

                String[] ejercito = new String[4];
                for (int i=0; i<=3; i++) {
                    ejercito[i] = "";
                }
                String mensaje = "Ejército óptimo: ";
                for (int i=0; i<=2; i++) {
                    System.out.println("el valor de I es: "+i);
                    if (vars[i] != 0) {
                        ejercito[vars[i]-1] =  String.format("%.0f", Math.ceil(matriz[i][7]));

                        System.out.println("[" + i + "," + vars[i] + "] = " + matriz[i][vars[i]-1]);
                        mensaje += String.format("%.0f", Math.ceil(matriz[i][7]));
                        switch(vars[i]) {
                            case 1: mensaje += " espadachines, "; break;
                            case 2: mensaje += " arqueros, "; break;
                            case 3: mensaje += " jinetes, "; break;
                            case 4: mensaje += " unidades únicas, "; break;
                        }
                    }
                }
                mensaje = mensaje.substring(0, mensaje.length() - 2);
                System.out.println(mensaje);

                mostrarDialogo(ejercito[0], ejercito[1], ejercito[2], ejercito[3]);

                Vibrator vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
            }
        });

        return root;
    }

    public static float determinante(float aii, float ajj, float aij, float aji) {
        float result = (aii * ajj) - (aij * aji);
        return result;
      }
       
      public static float[][] inicializarSimplex(int comida, int oro, int madera, int uuc, int uuo, int uum, int uud) {
        float[][] newArr = new float[4][9];
        // carga de espadachin, arquero y jinete (X1, X2, X3)
        newArr[0][0]=60; newArr[1][0]=20; newArr[2][0]=0; newArr[3][0]=-6;
        newArr[0][1]=0; newArr[1][1]=45; newArr[2][1]=25; newArr[3][1]=-4;
        newArr[0][2]=60; newArr[1][2]=75; newArr[2][2]=0; newArr[3][2]=-10;
        
        // carga de la unidad unica (X4)
        newArr[0][3]=uuc; newArr[1][3]=uuo; newArr[2][3]=uum; newArr[3][3]=-uud;
             
        // carga de las variables slack (S1, S2, S3)
        for (int j=4; j<=6; j++) {
          for (int i=0; i<=3; i++) {
            if (i == (j-4)) { newArr[i][j] = 1; } 
            else { newArr[i][j] = 0; }
          }
        }
             
        // carga del termino independiente B y THETA
        newArr[0][7]=comida; newArr[1][7]=oro; newArr[2][7]=madera; newArr[3][7]=0;
        for (int i=0; i<=3; i++) { newArr[i][8] = 0; }
           
        return newArr;
      }

      public static void imprimirSimplex(float[][] spx, int[] vars) {
        for (int i=0; i<=3; i++) {
          String renglon = "";
          for (int j=0; j<=7; j++) {
            //renglon += String.valueOf(spx[i][j]) + ", ";
            renglon += String.format("%.0f", spx[i][j]) + " | ";
          }
          System.out.println(renglon);
        }
        System.out.println("Variables X: [ "+vars[0]+" - "+vars[1]+" - "+vars[2]+" ]");
        System.out.println("            -----");
      }

      public static float[][] calcularSimplex(float[][] spx, int[] vars) {
        boolean hayZNegativo = false;
        for (int j=0; j<=3; j++) {
          if (spx[3][j] < 0) { 
            hayZNegativo = true; 
          }
        }
        
        if (hayZNegativo) {
          // si aún queda un negativo se sigue resolviendo
          float minValue = 0; // solo consideramos los negativos
          int colPivot = -1; // será la columna pivot
          // buscamos el mínimo Z (columna pivot)
          for (int j=0; j<=3; j++) { 
            if (spx[3][j] < minValue) {
              colPivot = j;
              minValue = spx[3][j];
            }
          }
          
          boolean hayThetaValido = false;
          minValue = 999999;
          int filaPivot = -1;
          // buscamos el minimo THETA (fila pivot)
          for (int i=0; i<=2; i++) { 
            spx[i][8] = spx[i][7] / spx[i][colPivot]; 
            if (spx[i][8] > 0) {
              hayThetaValido = true;
              if (spx[i][8] < minValue) {
                filaPivot = i;
                minValue = spx[i][8];
              }
            }
          }
          
          if (filaPivot != -1) {
            float[][] aux = new float[4][9]; // matriz nueva
            // si hubo fila pivot entonces se sigue el desarrollo 
            float pivot = spx[filaPivot][colPivot]; 
            for (int i=0; i<=3; i++) {
              for (int j=0; j<=7; j++) {
                if (i != filaPivot) {
                  // en cualquier fila se calcula como determinante / pivot
                  aux[i][j] = determinante(pivot, spx[i][j], spx[i][colPivot], spx[filaPivot][j]) / pivot;
                }
                else {
                  // si estamos en la misma fila solo dividimos por el pivot
                  aux[i][j] = spx[i][j] / pivot;
                }
              }
              aux[i][8] = 0; // inicializo en cero la columna de los THETA  
            }
            
            vars[filaPivot] = colPivot + 1;
            
            imprimirSimplex(aux, vars);
            spx = calcularSimplex(aux, vars);
          } 
          else {
            System.out.println("Fin del procesamiento, no hay theta válido");
          }
        } 
        else {
          // si no hay más negativos se termina la recursión
          System.out.println("Fin del procesamiento, no hay Z negativo");
        }
        return spx;
      }



    //Boton OK y Share - Dialog Creado
    private void mostrarDialogo(String cantInf, String cantArq, String cantCab, String cantUU) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_personalizado, null);
        builder.setView(view);

        dialogShare = view.findViewById(R.id.dialogCompleto);

        final AlertDialog dialog = builder.create();
        dialog.show();


        TextView txtArq= view.findViewById(R.id.cantArqueros);
        txtArq.setText(cantArq);
        TextView txtJin= view.findViewById(R.id.cantJinetes);
        txtJin.setText(cantCab);
        TextView txtUU= view.findViewById(R.id.cantUnidadU);
        txtUU.setText(cantUU);
        TextView txtInf= view.findViewById(R.id.cantInfanteria);
        txtInf.setText(cantInf);

        Button btnOk = view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Resultado mostrado", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Button btnShare = view.findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirApp();
            }
        });

    }

    //Configuracion del SHARE
    private void compartirApp(){
        Bitmap bmap = getBitmapFromView(dialogShare);
        try {
            File file = new File(getContext().getExternalCacheDir(),"resultado_optimo.png");
            FileOutputStream fout = new FileOutputStream(file);
            bmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
            fout.flush();
            fout.close();
            file.setReadable(true,false);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            startActivity(Intent.createChooser(intent, "Share with"));
        }catch (Exception e){

        }
    }

    //Pasar el layout a img
    @SuppressLint("ResourceAsColor")
    private Bitmap getBitmapFromView(View view){
        Bitmap returnedBitmap =Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if(bgDrawable != null){
            bgDrawable.draw(canvas);
        }else {
            canvas.drawColor(android.R.color.white);
        }
        view.draw(canvas);
        return returnedBitmap;
    }
}


