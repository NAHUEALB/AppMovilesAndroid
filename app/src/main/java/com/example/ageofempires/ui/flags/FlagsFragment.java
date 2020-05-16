package com.example.ageofempires.ui.flags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.Adapter.AdaptadorRecyclerFlags;
import com.example.ageofempires.MainActivity;
import com.example.ageofempires.R;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class FlagsFragment extends Fragment {

    ArrayList<Civilization> listCivilization;

    RecyclerView recyclerCivi;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_flags, container, false);
        listCivilization = MainActivity.listCivilization;
        recyclerCivi = root.findViewById(R.id.recyclerd_flagsId);
        recyclerCivi.setLayoutManager(new GridLayoutManager(getContext(),4));
        AdaptadorRecyclerFlags adapter = new AdaptadorRecyclerFlags(listCivilization);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "PERTENECE A: "+ listCivilization.get(recyclerCivi.getChildAdapterPosition(v)).getArquitectura(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerCivi.setAdapter(adapter);



        return root;
    }



}
