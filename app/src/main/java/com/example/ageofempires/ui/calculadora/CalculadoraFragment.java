package com.example.ageofempires.ui.calculadora;

import android.content.Context;
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
    EditText piedraET;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_calculadora, container,false);

        Button btn_calcu = root.findViewById(R.id.btn_calcular);
        comidaET = root.findViewById(R.id.comida_num);

        oroET = root.findViewById(R.id.oro_num);

        maderaET = root.findViewById(R.id.madera_num);

        piedraET = root.findViewById(R.id.piedra_num);


        btn_calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numC = Integer.parseInt(comidaET.getText().toString());
                Integer numO = Integer.parseInt(oroET.getText().toString());
                Integer numM = Integer.parseInt(maderaET.getText().toString());
                Integer numP = Integer.parseInt(piedraET.getText().toString());

                Toast.makeText(getContext(), "El valor ingresado es "+ numM+", "+numC+", "+numO+", "+numP, Toast.LENGTH_LONG).show();
                Vibrator vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
            }
        });
        return root;
    }

}
