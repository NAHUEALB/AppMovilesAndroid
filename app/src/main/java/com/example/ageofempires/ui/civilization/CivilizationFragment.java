package com.example.ageofempires.ui.civilization;

import com.example.ageofempires.*;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.Adapter.AdaptadorRecycler;
import com.example.ageofempires.R;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class CivilizationFragment extends Fragment {

   // private HomeViewModel homeViewModel;
   ArrayList<Civilization> listCivilization;

   RecyclerView recyclerCivi;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_civilization, container,false);

        listCivilization = MainActivity.listCivilization;

        recyclerCivi = root.findViewById(R.id.recyclerdId);
        recyclerCivi.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorRecycler adapter = new AdaptadorRecycler(listCivilization);

        recyclerCivi.setAdapter(adapter);


        return root;
    }


}
