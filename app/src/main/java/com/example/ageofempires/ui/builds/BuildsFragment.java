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

    // private BuildsViewModel buildsViewModel;
    private Button btn_msj;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Creo la vista que se le va a devolver al controlador
        View root = inflater.inflate(R.layout.fragment_build, container, false);



        return root;
    }


}

