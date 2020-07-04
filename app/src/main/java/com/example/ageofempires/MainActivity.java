package com.example.ageofempires;


import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;


import com.example.ageofempires.entitys.Civilization;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static ArrayList<Civilization> listCivilization;

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
                R.id.nav_civilization, R.id.nav_flags, R.id.nav_build, R.id.nav_init, R.id.nav_calculadora)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        listCivilization = new ArrayList<>();


        loadCivilizations();
    /*      if (listCivilization.isEmpty()){
            Log.i("LISTA", "La Lista no se cargo");
        }
        else {
            Toast.makeText(this, "Se cargaron: "+ listCivilization.size()+" Civilizaciones", Toast.LENGTH_LONG ).show();
        }
    */



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




    public void loadCivilizations() {

        listCivilization.add(new Civilization("Aztecas","Nuevo Mundo","Infanteria y monjes","Guerrero jaguar","Atlati,Guerras florales","Templo Mayor",R.string.aztecasb,"Reliquias generan +33 oro", R.drawable.aztecas));


        listCivilization.add(new Civilization("Bereberes","Medio oriente","Camellos y barcos","Camello arquero","Alcazabas,Dromedarios magrebíes","Torre Hasán",R.string.bereberesb,"Escaramuzador Zenete disponible en Galeria de tiro con arco desde la edad de Castillos",R.drawable.berberes));

        listCivilization.add(new Civilization("Birmanos","Sudeste Asiático","Monjes y elefantes","Arambai","Howdah,Caballería manipur","Pagoda de Shwezigon",R.string.birmanosb,"Las reliquias son visibles desde el inicio de la partida", R.drawable.birmanos));

        listCivilization.add(new Civilization("Bizantinos","Mediterranea","Defensa","Catafracta","Fuego Griego,Logistica","Hagia_Sophia",R.string.bizantinosb,"Monjes sanan 50% más rapidos.",R.drawable.bizantinos));

        listCivilization.add(new Civilization("Búlgaros","Europa del este","Infantería","Konnik","Estribos,Nobles Bagain","Iglesia redonda",R.string.bulgarosb,"La herrería trabaja 50% más rápido", R.drawable.bulgaros));

        listCivilization.add(new Civilization("Celtas","Europa Occidental","Infanteria y armas de asedio","Invasor de pastos","Bastion y Furor Celta","Carraig Phadraig",R.string.celtasb,"Taller de maquinaria de asedio trabajan 20% mas rapido",R.drawable.celtas));

        listCivilization.add(new Civilization("Chinos","Asia Oriental","Arqueros","Chu ko nu","Gran Muralla y Coheteria","Templo del Cielo",R.string.chinosb,"Granjas +45 alimento",R.drawable.chinos));

        listCivilization.add(new Civilization("Coreanos","Asia Oriental","Defensa y naval","Carreta de guerra,Barco tortuga","Panokseon,Shinkichon","Hwangnyongsa",R.string.coreanosb,"Alcance minimo de mangoneles reducido",R.drawable.coreanos));

        listCivilization.add(new Civilization("Cumanos","Asia occidental","Caballería","Kipchak","Ganadería de la estepa,Mercenario cumano","Sarkel",R.string.cumanosb,"Empalizadas tienen +50% de puntos de resistencia",R.drawable.cumanos));

        listCivilization.add(new Civilization("Francos","Europa Occidental","Caballeria","Lanzador de hachas","Codigo caballeresco y Hacha de arista","Catedral de San Vito",R.string.francosb,"Jinetes +2 de vision.",R.drawable.francos));

        listCivilization.add(new Civilization("Eslavos","Europa del este","Infantería y armas de asedio","Boyardo","Ortodoxia,Druzhina","Iglesia de la transformación",R.string.eslavosb,"Edificios militares(excepto castillos y muelles) albergan +5 de población", R.drawable.eslavos));

        listCivilization.add(new Civilization("Etíopes","Africana","Arqueros y armas de asedio","Shotelai","Centralización,Mecanismos de Torsión","Biet Medhani Alem",R.string.etiopesb,"Torres y puestos avanzados +3 línea de visión",R.drawable.etiopes));

        listCivilization.add(new Civilization("Españoles","Mediterránea","Monjes y pólvora","Conquistador,Misionera","Inquisición,Supremacia","Torre del oro",R.string.españolesb,"Unidades comerciales generan 25% oro",R.drawable.espanioles));

        listCivilization.add(new Civilization("Godos","Europa Central","Infanteria","Huscarle","Anarquia,Movilizacion","Mausoleo de Teodorico",R.string.godosb,"Cuarteles cuestan 20% más rapido",R.drawable.godos));

        listCivilization.add(new Civilization("Hunos","Europa Central","Caballería","Tarcano","Razias,Ateísmo","Arco de constantino",R.string.hunosb,"Establos funcionan 20% más rápidos",R.drawable.hunos));

        listCivilization.add(new Civilization("Incas","Nuevo mundo","Infantería","Kamayouk","Huaracas,Postas","Templo del sol",R.string.incasb,"Granjas son constuidas 50% más rápido",R.drawable.incas));

        listCivilization.add(new Civilization("Indios","Asia del sur","Camellos y pólvora","Elefante arquero,Camello imperial","Sultanato,Shatagni","Gol Gumbaz,Templo Brihadisvara",R.string.indiosb,"Camellos +6 ataque contra edificios",R.drawable.indios));

        listCivilization.add(new Civilization("Ingleses","Europa Occidental","Arqueros","Arquero de tipo largo","Voluntarios de caballeria,Warwof","Catedral de Asquigrán,Catedral de Chichester",R.string.inglesesb,"Galerias de tiro con arco funcionan 20% más rapido",R.drawable.ingleses));

        listCivilization.add(new Civilization("Italianos","Mediterranea","Arqueros y barcos","Genoves ballestero","Escudo Pavés,Ruta de la seda","Catedral de Génova",R.string.italianosb,"Condotiero disponible en el cuartel de la edad Imperial",R.drawable.italianos));

        listCivilization.add(new Civilization("Japoneses","Asia Oriental","Infanteria","Samurai","Yasama,Kataparuto","Todai-ji",R.string.japonesesb,"Galeras +50% en línea de visión",R.drawable.japoneses));

        listCivilization.add(new Civilization("Jemeres","Sudeste asiático","Elefantes y armas de asedio","Elefante con ballesta","Colmillos de acero,Doble ballesta","Angkor Wat",R.string.jemeresb,"Escropiones tienen +1 de alcance",R.drawable.jemeres));

        listCivilization.add(new Civilization("Lituanos","Europa del este","Caballería y monjes","Leitis","Castros bálticos,Escudo rectangular","Castillo de Trakai",R.string.lituanosb,"Monasterios trabajan 20% más rápidos",R.drawable.lituanos));

        listCivilization.add(new Civilization("Magiares","Europa del este","Caballería","Huszár magiar","Ejército corniviano,Arco recurvo","Castillo de Hunyad",R.string.magiaresb,"Arqueros a pie +2 línea de visión",R.drawable.magiares));

        listCivilization.add(new Civilization("Malayos","Sudeste asiático","Barcos","Guerrero con Karambit","Talasocracia,Leva en Masa","Kalasan",R.string.malayosb,"Muelles tienen el doble de línia de visión",R.drawable.malayos));

        listCivilization.add(new Civilization("Malíes","Africana","Infantería","Gbeto","Gran asamblea,Farimba","Gran mezquita de Djnne",R.string.maliesb,"Las mejores de la universidad son 80% más rápidas",R.drawable.malies));

        listCivilization.add(new Civilization("Mayas","Nuevo Mundo","Arqueros","Arquero de plumas","Saeta de Obsidiana,El dorado","Templo del gran jaguar",R.string.mayasb,"Empalizadas,murallas,portones y puertan cuestan -50%",R.drawable.mayas));

        listCivilization.add(new Civilization("Mongoles","Asia Oriental","Arqueros a caballo","Mangudai","Nomadas,Instrucción militar","Tienda de Gengis Khan", R.string.mongolesb,"Caballeria de exploracion +2 línea de visión",R.drawable.mongoles));

        listCivilization.add(new Civilization("Portugueses","Mediterránea","Barcos y unidades de pólvora","Cañon de salvas,Carabela","Carracas,Arcabuz","Torre de Belem",R.string.portuguesesb,"Cartografía gratis desde Edad Media",R.drawable.portugueses));

        listCivilization.add(new Civilization("Persas","Medio Oriente","Caballeria","Elefante de Guerra","barbacana,Cornacas","Taq-i Kisra",R.string.persasb,"Jinetes +2 ataque contra arqueros",R.drawable.persas));

        listCivilization.add(new Civilization("Sarracenos","Medio Oriente","Camellos y naval","Mameluco","Madraza,Fanatismo","Gran Mezquito de Samarra",R.string.sarrasenosb,"Arqueros a pie +1 en Feudal/ +2 en Castillos/ +3 en Imperial de ataque contra edificios",R.drawable.sarracenos));

        listCivilization.add(new Civilization("Tartaros","Asia occidental","Arqueros a caballos","Keshik","Armadura de seda,Tácticas de asedio timuridas","Observatorio de Ulugh Beg",R.string.tartarosb,"Arqueros a caballo +2 línea de visión",R.drawable.tartaros));

        listCivilization.add(new Civilization("Teutones","Europa Central","Infanteria","Caballero de la orden Teutónica","Blindaje,Almenas","Abadía de Santa Maria Laach",R.string.teutonesb,"Unidades son más resistentes a la conversión",R.drawable.teutones));

        listCivilization.add(new Civilization("Turcos","Medio Oriente","Polvora","Jenizaro","Sipahi,Artillería","Mezquita de Selim",R.string.turcosb,"Unidades de pólvora son creadas 20% más rápido",R.drawable.turcos));

        listCivilization.add(new Civilization("Vietnamitas","Asia oriental","Arqueros","Arquero de Ratan","Chatras,Papel moneda","Templo But Thap",R.string.vietnamitasb,"Guerrillero imperial disponible en la galería de tiro con arco",R.drawable.vietnamitas));

        listCivilization.add(new Civilization("Vikingos","Europa Central","Infantería y naval","Berserker,Barco Dragón","Hérsires,Trance Frenético","Iglesia de madera Borgound",R.string.vikingosb,"Muellen cuestan -15%",R.drawable.vikingos));
    }




}
