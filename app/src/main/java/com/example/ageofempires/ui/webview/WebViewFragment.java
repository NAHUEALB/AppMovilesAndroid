package com.example.ageofempires.ui.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.Navegador;
import com.example.ageofempires.R;

public class WebViewFragment extends Fragment {

    // private BuildsViewModel buildsViewModel;
    private Button btn_age1, btn_ageMitology, btn_age3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Creo la vista que se le va a devolver al controlador
        View root = inflater.inflate(R.layout.fragment_webview, container, false);

        btn_age1 = root.findViewById(R.id.btn_age1);
        btn_ageMitology = root.findViewById(R.id.btn_ageMytho);
        btn_age3 = root.findViewById(R.id.btn_age3);

        btn_age1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL = "https://ageofempires.fandom.com/es/wiki/Age_of_Empires";
                //Creo la nueva activity
                Intent web = new Intent(getContext(), Navegador.class);
                //Creo el objeto que le voy a mandar
                Bundle b = new Bundle();
                //Le meto datos a ese obj
                b.putString("URL", URL );
                //Le inyecto a esa activity el nuevo objeto
                web.putExtras(b);
                //Inicio la nueva actividad
                startActivity(web);

            }
        });

        btn_ageMitology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL = "https://ageofempires.fandom.com/es/wiki/Age_of_Mythology";
                //Creo la nueva activity
                Intent web = new Intent(getContext(), Navegador.class);
                //Creo el objeto que le voy a mandar
                Bundle b = new Bundle();
                //Le meto datos a ese obj
                b.putString("URL", URL );
                //Le inyecto a esa activity el nuevo objeto
                web.putExtras(b);
                //Inicio la nueva actividad
                startActivity(web);

            }
        });

        btn_age3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL = "https://ageofempires.fandom.com/es/wiki/Age_of_Empires_III";
                //Creo la nueva activity
                Intent web = new Intent(getContext(), Navegador.class);
                //Creo el objeto que le voy a mandar
                Bundle b = new Bundle();
                //Le meto datos a ese obj
                b.putString("URL", URL );
                //Le inyecto a esa activity el nuevo objeto
                web.putExtras(b);
                //Inicio la nueva actividad
                startActivity(web);

            }
        });

        return root;
    }

}

