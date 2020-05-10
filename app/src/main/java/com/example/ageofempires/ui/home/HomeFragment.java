package com.example.ageofempires.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.ConnectionSQL;
import com.example.ageofempires.R;
import com.example.ageofempires.Utilities.Utilities;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

   // private HomeViewModel homeViewModel;
    ArrayList<Civilization> listCivi;
    RecyclerView recyclerViewCivi;

    ConnectionSQL conn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        conn = new ConnectionSQL(getContext(), Utilities.TABLA_CIVILIZATION, null, 1);

        listCivi = new ArrayList<>();


        View root = inflater.inflate(R.layout.fragment_home, container,false);

        recyclerViewCivi = root.findViewById(R.id.recyclerdId);

        return root;
    }
}
