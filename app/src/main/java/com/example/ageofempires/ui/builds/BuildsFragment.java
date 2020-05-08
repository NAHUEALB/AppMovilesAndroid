package com.example.ageofempires.ui.builds;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.ConnectionSQL;
import com.example.ageofempires.R;
import com.example.ageofempires.Utilities.Utilities;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class BuildsFragment extends Fragment {

    ConnectionSQL connect;
    ListView listViewCivi;
    ArrayList<Civilization> listCivilization;
    ArrayList<String> listInformation;

    // private BuildsViewModel buildsViewModel;
    private Button btn_msj;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Creo la vista que se le va a devolver al controlador
        View root = inflater.inflate(R.layout.fragment_build, container, false);


        connect = new ConnectionSQL(getContext(),"bd_civilization", null, 1);
        listViewCivi = (ListView) root.findViewById(R.id.list_View);
        printListCivi();

        ArrayAdapter adaptador=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listInformation);
        listViewCivi.setAdapter(adaptador);




        return root;
    }

    private void printListCivi() {

        SQLiteDatabase db = connect.getReadableDatabase();

        Civilization civilization = null;
        listCivilization = new ArrayList<Civilization>();
        //Select * from Civilization
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilities.TABLA_CIVILIZATION, null);

        //Se mueve hasta el final
        while (cursor.moveToNext()){
            civilization = new Civilization();
            civilization.setId_Civi(cursor.getInt(0));
            civilization.setName_Civi(cursor.getString(1));
            civilization.setArquitectura(cursor.getString(2));
            civilization.setEspecialidad(cursor.getString(3));
            civilization.setUnidad_Unica(cursor.getString(4));
            civilization.setTecnologias(cursor.getString(5));
            civilization.setMaravilla(cursor.getString(6));
            civilization.setBonus(cursor.getString(7));
            civilization.setBonus_team(cursor.getString(8));
            Log.i("INFODATABASE", "LA ID CARGADA ES DE: "+civilization.getId_Civi());

           listCivilization.add(civilization);
        }
        obtenerLista();


    }

    private void obtenerLista() {
        listInformation = new ArrayList<String>();

        for (int i=0; i<listCivilization.size(); i++){
            listInformation.add( listCivilization.get(i).getId_Civi()+"-"
                    +listCivilization.get(i).getName_Civi()+"-"
                    +listCivilization.get(i).getArquitectura()+"-"
                    +listCivilization.get(i).getEspecialidad()+"-"
                    +listCivilization.get(i).getUnidad_Unica()+"-"
                    +listCivilization.get(i).getTecnologias()+"-"
                    +listCivilization.get(i).getMaravilla()+"-"
                    +listCivilization.get(i).getBonus()+"-"
                    +listCivilization.get(i).getBonus_team()

            );
        }
    }


}

