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
                Integer numC = Integer.parseInt(comidaET.getText().toString());
                Integer numO = Integer.parseInt(oroET.getText().toString());
                Integer numM = Integer.parseInt(maderaET.getText().toString());

                mostrarDialogoBasico(numC,numO ,numM );
                //Toast.makeText(getContext(), "El valor ingresado es "+ numM+", "+numC+", "+numO, Toast.LENGTH_LONG).show();
                //Brillo


                Vibrator vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
            }
        });

        return root;
    }



    //Boton OK y Share - Dialog Creado
    private void mostrarDialogoBasico( int numc, int numO, int numM) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_personalizado, null);
        builder.setView(view);

        dialogShare = view.findViewById(R.id.dialogCompleto);

        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView txtArq= view.findViewById(R.id.cantArqueros);
        txtArq.setText("400");
        TextView txtAld= view.findViewById(R.id.cantAldeanos);
        txtAld.setText("50");
        TextView txtJin= view.findViewById(R.id.cantJinetes);
        txtJin.setText("100");

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


