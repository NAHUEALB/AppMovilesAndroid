package com.example.ageofempires.ui.init;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.R;

public class initFragment extends Fragment {

    // private BuildsViewModel buildsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Creo la vista que se le va a devolver al controlador
        View root = inflater.inflate(R.layout.fragment_init, container, false);



        return root;
    }


}