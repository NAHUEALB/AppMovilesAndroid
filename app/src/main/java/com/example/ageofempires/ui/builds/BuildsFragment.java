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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.Adapter.AdaptadorRecycler;
import com.example.ageofempires.ConnectionSQL;
import com.example.ageofempires.R;
import com.example.ageofempires.Utilities.Utilities;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class BuildsFragment extends Fragment {

    ConnectionSQL connect;
    ListView listViewCivi;
    RecyclerView recycler;
    ArrayList<String> listDatos;

    // private BuildsViewModel buildsViewModel;
    private Button btn_msj;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Creo la vista que se le va a devolver al controlador
        View root = inflater.inflate(R.layout.fragment_build, container, false);

        recycler = root.findViewById(R.id.recyclerdId);

        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

        listDatos = new ArrayList<String>();
        for (int i=0 ; i <= 50 ; i++) {
            listDatos.add("Dato: #" + i + "");
        }

        AdaptadorRecycler adapter = new AdaptadorRecycler(listDatos);
        recycler.setAdapter(adapter);


        return root;
    }


}

