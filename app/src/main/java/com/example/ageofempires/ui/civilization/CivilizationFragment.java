package com.example.ageofempires.ui.civilization;

import com.example.ageofempires.*;

import android.content.res.Resources;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.Adapter.AdaptadorRecycler;
import com.example.ageofempires.Adapter.AdaptadorRecyclerMultiple;
import com.example.ageofempires.R;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class CivilizationFragment extends Fragment {

    // private HomeViewModel homeViewModel;
    ArrayList<Civilization> listCivilization;

    // arrays de civilizaciones agrupadas por "arquitecturas" (almost obsolete)
    //ArrayList<Civilization> civ_medit, civ_eurde, civ_eurce, civ_euroc, civ_medor, civ_sueas, civ_asori, civ_asocc, civ_asdsu, civ_afric, civ_ameri;

    // arrays de strings con los nombres de las civilizaciones agrupadas por "especialidades" (actual approach)
    ArrayList<String> civ_esp_infanteria, civ_esp_caballeria, civ_esp_arqueros, civ_esp_polvora, civ_esp_barcos, civ_esp_monjes;


    RecyclerView recyclerCivi;

    private Switch sw3;
    private LinearLayout buttonsContainer;
    private Boolean switchState;

    View root;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.i("CF", "onCreateView 1");

        root = inflater.inflate(R.layout.fragment_civilization, container,false);

        listCivilization = MainActivity.listCivilization;

        civ_esp_infanteria = new ArrayList<>(); civ_esp_infanteria.add("Aztecas"); civ_esp_infanteria.add("Búlgaros"); civ_esp_infanteria.add("Celtas"); civ_esp_infanteria.add("Eslavos"); civ_esp_infanteria.add("Godos"); civ_esp_infanteria.add("Incas"); civ_esp_infanteria.add("Japoneses"); civ_esp_infanteria.add("Malíes"); civ_esp_infanteria.add("Teutones"); civ_esp_infanteria.add("Vikingos");
        civ_esp_caballeria = new ArrayList<>(); civ_esp_caballeria.add("Bereberes"); civ_esp_caballeria.add("Birmanos"); civ_esp_caballeria.add("Bizantinos"); civ_esp_caballeria.add("Cumanos"); civ_esp_caballeria.add("Francos"); civ_esp_caballeria.add("Hunos"); civ_esp_caballeria.add("Indios"); civ_esp_caballeria.add("Jemeres"); civ_esp_caballeria.add("Lituanos"); civ_esp_caballeria.add("Magiares"); civ_esp_caballeria.add("Persas"); civ_esp_caballeria.add("Sarracenos");
        civ_esp_arqueros = new ArrayList<>(); civ_esp_arqueros.add("Chinos"); civ_esp_arqueros.add("Etíopes"); civ_esp_arqueros.add("Ingleses"); civ_esp_arqueros.add("Italianos"); civ_esp_arqueros.add("Mayas"); civ_esp_arqueros.add("Mongoles"); civ_esp_arqueros.add("Tartaros"); civ_esp_arqueros.add("Vietnamitas");
        civ_esp_polvora = new ArrayList<>(); civ_esp_polvora.add("Celtas"); civ_esp_polvora.add("Eslavos"); civ_esp_polvora.add("Etíopes"); civ_esp_polvora.add("Españoles"); civ_esp_polvora.add("Indios"); civ_esp_polvora.add("Jemeres"); civ_esp_polvora.add("Portugueses"); civ_esp_polvora.add("Turcos");
        civ_esp_barcos = new ArrayList<>(); civ_esp_barcos.add("Bereberes"); civ_esp_barcos.add("Coreanos"); civ_esp_barcos.add("Italianos"); civ_esp_barcos.add("Malayos"); civ_esp_barcos.add("Portugueses"); civ_esp_barcos.add("Sarracenos"); civ_esp_barcos.add("Vikingos");
        civ_esp_monjes = new ArrayList<>(); civ_esp_monjes.add("Aztecas"); civ_esp_monjes.add("Birmanos"); civ_esp_monjes.add("Españoles"); civ_esp_monjes.add("Lituanos");

        Log.i("CF", "onCreateView 2");



        Log.i("CF", "onCreateView 3");

        recyclerCivi = root.findViewById(R.id.recyclermu);
        recyclerCivi.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorRecyclerMultiple adapter = new AdaptadorRecyclerMultiple(listCivilization);
        recyclerCivi.setAdapter(adapter);
        Log.i("CF", "listCivilization OK" + listCivilization);
        Log.i("RY", "recyclerCivi OK" + recyclerCivi);

        buttonsContainer = root.findViewById(R.id.buttonslayout);
        Log.i("CF", "Cargando radiobuttons");

        sw3 = MainActivity.civswitch3;
        Log.i("SW", "¿cargó el civswitch?");
        Log.i("SW", MainActivity.civswitch3.getText().toString());

        switchState = sw3.isChecked();
        Log.i("SW", "El switch es " + switchState.toString());

        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on){
                Log.i("CV", "estoy en changeVisibility()!");
                //on = civswitch.isChecked();

                if (on) {
                    buttonsContainer.setVisibility(View.GONE);
                    Log.i("Switch ON", "Se traerán todas");
                } else {
                    buttonsContainer.setVisibility(View.VISIBLE);
                    Log.i("Switch OFF", "Mostrando filtros");
                }
            }
        });
        return root;
    }

}








// Código OBSOLETO

        /* civ_medit = new ArrayList<>(); civ_eurde = new ArrayList<>(); civ_eurce = new ArrayList<>(); civ_euroc = new ArrayList<>(); civ_medor = new ArrayList<>(); civ_sueas = new ArrayList<>(); civ_asori = new ArrayList<>(); civ_asocc = new ArrayList<>(); civ_asdsu = new ArrayList<>(); civ_afric = new ArrayList<>(); civ_ameri = new ArrayList<>();
        // llena los arrays filtrando por arquitecturas (obsoleto, dejar minimizado)
        for (int i=0; i<listCivilization.size(); i++) {
            //Civilization new_civ = new Civilization(listCivilization.get(i).getName_Civi(), listCivilization.get(i).getArquitectura(),listCivilization.get(i).getEspecialidad(),listCivilization.get(i).getUnidad_Unica(),listCivilization.get(i).getTecnologias(),listCivilization.get(i).getMaravilla() ,R.string.vikingosb,listCivilization.get(i).getBonus_team(),R.drawable.vikingos);
            Civilization new_civ = listCivilization.get(i);
            switch ((new_civ.getArquitectura()).toLowerCase()) {
                case "mediterránea":
                    civ_medit.add(new_civ);
                    break;
                case "europa del este":
                    civ_eurde.add(new_civ);
                    break;
                case "europa central":
                    civ_eurce.add(new_civ);
                    break;
                case "europa occidental":
                    civ_euroc.add(new_civ);
                    break;
                case "medio oriente":
                    civ_medor.add(new_civ);
                    break;
                case "sudeste asiático":
                    civ_sueas.add(new_civ);
                    break;
                case "asia oriental":
                    civ_asori.add(new_civ);
                    break;
                case "asia occidental":
                    civ_asocc.add(new_civ);
                    break;
                case "asia del sur":
                    civ_asdsu.add(new_civ);
                    break;
                case "africana":
                    civ_afric.add(new_civ);
                    break;
                case "nuevo mundo":
                    civ_ameri.add(new_civ);
                    break;
                default:
                    break;
            }
        } */
