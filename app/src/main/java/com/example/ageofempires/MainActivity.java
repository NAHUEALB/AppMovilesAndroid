package com.example.ageofempires;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.example.ageofempires.Utilities.Utilities;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_civilization, R.id.nav_flags, R.id.nav_build)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
         cargarCivilizacion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    private void cargarCivilizacion(){
        //Conecto la BD
        ConnectionSQL connect = new ConnectionSQL(this,"bd_civilization", null, 1);
        if (connect != null){
            Log.i("INFO", "LA BD SE CONECTO CORRECTAMENTE");

        //Levanto la BD para poder escribirla y/o leerla
        SQLiteDatabase db = connect.getWritableDatabase();
        if(db ==null ){
            Log.i("Estado de la BD", "Esta vacia");
        }
        else {
            Log.i("Estado de la BD", "NO Esta vacia");
        }

        //Completo el objeto values y se lo paso a la BD
        ContentValues values = new ContentValues();
        values.put(Utilities.CAMPO_NAME_CIVI, "Bizantinos");
        values.put(Utilities.CAMPO_ARQUITECTURA, "Mediterranea");
        values.put(Utilities.CAMPO_ESPECIALIDAD, "Defensa");
        values.put(Utilities.CAMPO_UNIDAD_UNICA, "Catafracta");
        values.put(Utilities.CAMPO_TECNOLOGIAS, "Fuego Griego, Logistica");
        values.put(Utilities.CAMPO_MARAVILLA, "Hagia_Sophia");
        values.put(Utilities.CAMPO_BONUS, "Edificios tienen +10% (Alta Edad Media)/+20% (Ed.Feudal)/+30% (Ed. Castillos)/+40% (Ed. Imperial) Puntos de Resistencia");
        values.put(Utilities.CAMPO_BONUS_TEAM, "Monjes sanan 50% más rapidos.");


        long newRowId = db.insert(Utilities.TABLA_CIVILIZATION, null, values);


        Toast.makeText(this, "La id generada es: "+ newRowId, Toast.LENGTH_LONG).show();

        }
    }

}
