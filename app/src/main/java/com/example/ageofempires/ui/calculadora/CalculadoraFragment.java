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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.R;

import org.w3c.dom.Text;

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
                //Brillo


                Vibrator vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
            }
        });

        return root;
    }




    private void mostrarDialogoBasico( int numc, int numO, int numM) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_personalizado, null);
        builder.setView(view);

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

    }
}


