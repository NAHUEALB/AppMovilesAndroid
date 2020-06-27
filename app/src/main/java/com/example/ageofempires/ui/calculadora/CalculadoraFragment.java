package com.example.ageofempires.ui.calculadora;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.R;

public class CalculadoraFragment  extends Fragment {

    EditText comidaET;
    EditText oroET;
    EditText maderaET;

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
                Vibrator vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
            }
        });

        return root;
    }




    private void mostrarDialogoBasico( int numc, int numO, int numM){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("RESULTADO OPTIMO DE EJERCITO: ");
        builder.setMessage("Necesitarias: "+numc+"Jinetes"+numM+"Espadachin "+numO+"Ballesteros"+numc+"Unidad Unica")
                .setPositiveButton("Share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Datos compartidos", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Datos mostrados", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                }).show();
    }
}


