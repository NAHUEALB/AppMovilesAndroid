package com.example.ageofempires.ui.builds;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ageofempires.R;

public class BuildsFragment extends Fragment {

    // private BuildsViewModel buildsViewModel;
    private WebView webView;
    private Button btn_age1, btn_ageMitology, btn_age3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Creo la vista que se le va a devolver al controlador
        View root = inflater.inflate(R.layout.fragment_build, container, false);

        btn_age1 = root.findViewById(R.id.btn_age1);
        btn_ageMitology = root.findViewById(R.id.btn_ageMytho);
        btn_age3 = root.findViewById(R.id.btn_age3);



        webView = root.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        btn_age1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webView.loadUrl("https://ageofempires.fandom.com/es/wiki/Age_of_Empires");
            }
        });


        return root;
    }

}

