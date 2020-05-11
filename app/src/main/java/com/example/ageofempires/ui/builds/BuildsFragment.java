package com.example.ageofempires.ui.builds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.R;

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

