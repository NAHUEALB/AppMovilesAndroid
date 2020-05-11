package com.example.ageofempires.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.Adapter.AdaptadorRecycler;
import com.example.ageofempires.R;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

   // private HomeViewModel homeViewModel;
   ArrayList<Civilization> listCivilization;
    RecyclerView recyclerCivi;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {





        View root = inflater.inflate(R.layout.fragment_home, container,false);
        listCivilization = new ArrayList<>();
        recyclerCivi = root.findViewById(R.id.recyclerdId);
        recyclerCivi.setLayoutManager(new LinearLayoutManager(getContext()));

        loadCivilizations();
        if (listCivilization.isEmpty()){
            Log.i("LISTA", "La Lista no se cargo");
        }
        else {
            Toast.makeText(getContext(), "Se cargaron: "+ listCivilization.size()+" Civilizaciones", Toast.LENGTH_LONG ).show();
        }


        AdaptadorRecycler adapter = new AdaptadorRecycler(listCivilization);

        recyclerCivi.setAdapter(adapter);


        return root;
    }

    public void loadCivilizations() {

        listCivilization.add(new Civilization("Bizantinos","Mediterranea","Defensa","Catafracta","Fuego Griego,Logistica","Hagia_Sophia",R.string.bizantinosb,"Monjes sanan 50% más rapidos.",R.drawable.bizantinos));
        listCivilization.add(new Civilization("Celtas","Europa Occidental","Infanteria y armas de asedio","Invasor de pastos","Bastion y Furor Celta","Carraig Phadraig",R.string.celtasb,"Taller de maquinaria de asedio trabajan 20% mas rapido",R.drawable.celtas));
        listCivilization.add(new Civilization("Chinos","Asia Oriental","Arqueros","Chu ko nu","Gran Muralla y Coheteria","Templo del Cielo",R.string.chinosb,"Granjas +45 alimento",R.drawable.chinos));
        listCivilization.add(new Civilization("Francos","Europa Occidental","Caballeria","Lanzador de hachas","Codigo caballeresco y Hacha de arista","Catedral de San Vito",R.string.francosb,"Jinetes +2 de vision.",R.drawable.francos));
        listCivilization.add(new Civilization("Sarracenos","Medio Oriente","Camellos y naval","Mameluco","Madraza,Fanatismo","Gran Mezquita de Samarra",R.string.sarrasenosb,"Arqueros a pie +1 (Feudal)/+2 (Castillos)/+3 (Imperial) de ataque contra edificios.",R.drawable.sarracenos));
        listCivilization.add(new Civilization("Persas","Medio Oriente","Caballeria","Elefante de guerra","Barbacana,Cornacas","Taq-i-Kisra",R.string.persasb,"Jinetes +2 ataque contra arqueros.",R.drawable.persas));
        listCivilization.add(new Civilization("Mongoles","Asia Oriental","Arqueros a caballo","Mangudia","Nómadas,Instrucción Militar","Tienda de Gengis Khan",R.string.mongolesb,"Caballería de exploración +2 LDV.",R.drawable.mongoles));
        listCivilization.add(new Civilization("Godos","Europa Central","Infanteria","Huscarle","Anarquia,Movilizacion","Mausoleo de Teodorico",R.string.godosb,"Cuarteles cuestan 20% más rapido",R.drawable.godos));
        listCivilization.add(new Civilization("Ingleses","Europa Occidental","Arqueros","Arquero de tipo largo","Voluntarios de caballeria,Warwof","Catedral de Asquigrán,Catedral de Chichester",R.string.inglesesb,"Galerias de tiro con arco funcionan 20% más rapido",R.drawable.ingleses));
        // listCivilization.add(new Civilization("Japoneses","Asia Oriental","Infanteria","Samurai","Yasama,Kataparuto","Todai-ji","Molino", R.string.japonesesb ,"Galeras +50% en línea de visión",R.drawable.japoneses));

    }
}
