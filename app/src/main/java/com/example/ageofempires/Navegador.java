package com.example.ageofempires;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Navegador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        WebView view = findViewById(R.id.webview);
        view.setWebViewClient(new WebViewClient());

        Bundle objeto_recibido = getIntent().getExtras();
        if (objeto_recibido != null) {
            //Saco del objeto solo lo que necesito
            String parametro_recibido = objeto_recibido.getString("URL");
            view.loadUrl(parametro_recibido);
        }


    }
}
