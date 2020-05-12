package com.example.ageofempires;


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
                R.id.nav_civilization, R.id.nav_flags, R.id.nav_build, R.id.nav_init)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        listCivilization = new ArrayList<>();


        loadCivilizations();
        if (listCivilization.isEmpty()){
            Log.i("LISTA", "La Lista no se cargo");
        }
        else {
            Toast.makeText(this, "Se cargaron: "+ listCivilization.size()+" Civilizaciones", Toast.LENGTH_LONG ).show();
        }




    }


    public void loadCivilizations() {

        listCivilization.add(new Civilization("Bizantinos","Mediterranea","Defensa","Catafracta","Fuego Griego,Logistica","Hagia_Sophia",R.string.bizantinosb,"Monjes sanan 50% más rapidos.",R.drawable.bizantinos));
        listCivilization.add(new Civilization("Celtas","Europa Occidental","Infanteria y armas de asedio","Invasor de pastos","Bastion y Furor Celta","Carraig Phadraig",R.string.celtasb,"Taller de maquinaria de asedio trabajan 20% mas rapido",R.drawable.celtas));
        listCivilization.add(new Civilization("Chinos","Asia Oriental","Arqueros","Chu ko nu","Gran Muralla y Coheteria","Templo del Cielo",R.string.chinosb,"Granjas +45 alimento",R.drawable.chinos));
        listCivilization.add(new Civilization("Francos","Europa Occidental","Caballeria","Lanzador de hachas","Codigo caballeresco y Hacha de arista","Catedral de San Vito",R.string.francosb,"Jinetes +2 de vision.",R.drawable.francos));

        listCivilization.add(new Civilization("Aztecas","Nuevo Mundo","Infanteria y monjes","Guerrero jaguar","Atlati,Guerras florales","Templo Mayor",R.string.aztecasb,"Reliquias generan +33 oro", R.drawable.aztecas));

        listCivilization.add(new Civilization("Bereberes","Medio oriente","Camellos y barcos","Camello arquero","Alcazabas,Dromedarios magrebíes","Torre Hasán",R.string.bereberesb,"Escaramuzador Zenete disponible en Galeria de tiro con arco desde la edad de Castillos",R.drawable.bereberes));

        listCivilization.add(new Civilization("Birmanos","Sudeste Asiático","Monjes y elefantes","Arambai","Howdah,Caballería manipur","Pagoda de Shwezigon",R.string.birmanosb,"Las reliquias son visibles desde el inicio de la partida", R.drawable.birmanosb));

        listCivilization.add(new Civilization("Bizantinos","Mediterranea","Defensa","Catafracta","Fuego Griego,Logistica","Hagia_Sophia",R.string.bizantinosb,"Monjes sanan 50% más rapidos.",R.drawable.bizantinos));

        listCivilization.add(new Civilization("Búlgaros","Europa del este","Infantería","Konnik","Estribos,Nobles Bagain","Iglesia redonda",R.string.bulgarosb,"La herrería trabaja 50% más rápido", R.drawable.bulgarosb));

        listCivilization.add(new Civilization("Coreanos","Asia Oriental","Defensa y naval","Carreta de guerra,Barco tortuga","Panokseon,Shinkichon","Hwangnyongsa",R.string.coreanosb,"Alcance minimo de mangoneles reducido",R.drawable.coreanos));

        listCivilization.add(new Civilization("Cumanos","Asia occidental","Caballería","Kipchak","Ganadería de la estepa,Mercenario cumano","Sarkel",R.string.cumanosb,"Empalizadas tienen +50% de puntos de resistencia",R.drawable.cumanos));

        listCivilization.add(new Civilization("Eslavos","Europa del este","Infantería y armas de asedio","Boyardo","Ortodoxia,Druzhina","Iglesia de la transformación",R.string.eslavosb,"Edificios militares(excepto castillos y muelles) albergan +5 de población", R.drawable.eslavos));
/*
        listCivilization.add(new Civilization("Etíopes","Africana","Arqueros y armas de asedio","Shotelai","Centralización,Mecanismos de Torsión","Biet Medhani Alem","Arqueros disparan 15% más rápidos,Reciben +100 alimento y +100 de oro cuando avanzan de edad,Mejora a piquero gratis","Torres y puestos avanzados +3 línea de visión"));

        listCivilization.add(new Civilization("Españoles","Mediterránea","Monjes y pólvora","Conquistador,Misionera","Inquisición,Supremacia","Torre del oro","Mejores en herrería no cuestan oro,Galeones artillados se benefician de balística,Artilleros manuales y cañones de asedio disparan 15% más rápido","Unidades comerciales generan 25% oro"));

        listCivilization.add(new Civilization("Godos","Europa Central","Infanteria","Huscarle","Anarquia,Movilizacion","Mausoleo de Teodorico","Unidades de infanteria cuestan -35% a partir de la Edad Feudal,Infanteria +1 de ataque contra edificios,+10 población máxima en Edad Imperial","Cuarteles cuestan 20% más rapido"));

        listCivilization.add(new Civilization("Hunos","Europa Central","Caballería","Tarcano","Razias,Ateísmo","Arco de constantino","No necesitan casas pero comienza con -100 madera,Arqueros a caballo cuestan -10% en Castillos y -20% en Imperial,Lanzapiedras son 30$ más rápidos","Establos funcionan 20% más rápidos"));

        listCivilization.add(new Civilization("Incas","Nuevo mundo","Infantería","Kamayouk","Huaracas,Postas","Templo del sol","Aldeanos se benefician de las mejoras de infantería en la herrería,Casas albergan 10 de población,Edificios cuestan -15% piedra","Granjas son constuidas 50% más rápido"));

        listCivilization.add(new Civilization("Indios","Asia del sur","Camellos y pólvora","Elefante arquero,Camello imperial","Sultanato,Shatagni","Gol Gumbaz,Templo Brihadisvara","Aldeanos cuestan -10% en Edad Media/-15% en Feudal/-20% en Castillos/-25% en Imperial,Pescadores trabajan 15% más rápido y recogen +15 de alimento,Camellos +1 de armadura antiproyectil","Camellos +6 ataque contra edificios"));

        listCivilization.add(new Civilization("Ingleses","Europa Occidental","Arqueros","Arquero de tipo largo","Voluntarios de caballeria,Warwof","Catedral de Asquigrán,Catedral de Chichester","Centros urbanos cuestan -50% de madera en Edad de los Castillos,Arqueros a pie tienen +1 de alcance en castillos y +1 en Imperial,Pastores trabajan 25% más rápido","Galerias de tiro con arco funcionan 20% más rapido"));

        listCivilization.add(new Civilization("Italianos","Mediterranea","Arqueros y barcos","Genoves ballestero","Escudo Pavés,Ruta de la seda","Catedral de Génova","Tecnologías en el muelle cuestan -50%,Pesquero cuesta -20%,Avanzar de edad cuesta -15%","Condotiero disponible en el cuartel de la edad Imperial"));

        listCivilization.add(new Civilization("Japoneses","Asia Oriental","Infanteria","Samurai","Yasama,Kataparuto","Todai-ji","Molino, campamento minero/maderero cuestan -50%,Infanteria ataca 25% más rápido a partir de Edad Feudal,Pesqueros doble puntos de resistencia/trabajan +5% en Edad Media/+10% en Feudal/+15% en Castillos,+20% en Imperial más rápido","Galeras +50% en línea de visión"));

        listCivilization.add(new Civilization("Jemeres","Sudeste asiático","Elefantes y armas de asedio","Elefante con ballesta","Colmillos de acero,Doble ballesta","Angkor Wat","Los edificios no son requeridos para avanzar de edad,Los aldeanos pueden guardarse en las casas,Elefante de combate se mueven 15% más rápido","Escropiones tienen +1 de alcance"));

        listCivilization.add(new Civilization("Lituanos","Europa del este","Caballería y monjes","Leitis","Castros bálticos,Escudo rectangular","Castillo de Trakai","Comienzan con +150 de alimento,Lanceros y guerrilleros se mueven 10% más rápido","La caballería obtiene +1 ataque por cada reliquia guardada","Monasterios trabajan 20% más rápidos"));

        listCivilization.add(new Civilization("Magiares","Europa del este","Caballería","Huszár magiar","Ejército corniviano,Arco recurvo","Castillo de Hunyad","Forja, fundición de hierro y alto horno gratis,Caballería de exploración cuesta -15%,Aldeanos matan animales salvajes de un golpe","Arqueros a pie +2 línea de visión"));

        listCivilization.add(new Civilization("Malayos","Sudeste asiático","Barcos","Guerrero con Karambit","Talasocracia,Leva en Masa","Kalasan","Avanzar de edad es 80% más rápido,Trampa para peces cuesan -33% y proveen alimentos ilimitados,Elefante de combate cuesta -30%","Muelles tienen el doble de línia de visión"));

        listCivilization.add(new Civilization("Malíes","Africana","Infantería","Gbeto","Gran asamblea,Farimba","Gran mezquita de Djnne","Edificios cuestan +15% madera,Unidades de cuartel tienen +1 en Feudal/+2 en Castillos/+3 en Imperial de armadura anti proyectil","Las mejores de la universidad son 80% más rápidas"));

        listCivilization.add(new Civilization("Mayas","Nuevo Mundo","Arqueros","Arquero de plumas","Saeta de Obsidiana,El dorado","Templo del gran jaguar","Comienzan con un aldeano más pero con -50 de alimento,Recursas duran 15% más,Arqueros cuestan -10%/-20% en Castillos/-30% en Imperial","Empalizadas,murallas,portones y puertan cuestan -50%"

                listCivilization.add(new Civilization("Mongoles","Asia Oriental","Arqueros a caballo","Mangudai","Nomadas,Intrucción militar","Arqueros a caballo disparan 20% más rápido,Caballería ligera y húsar +30% puntos,Cazadores trabajan 50% más rápido","Caballeria de exploracion +2 línea de visión"));

        listCivilization.add(new Civilization("Persas","Medio Oriente","Elefante de guerra","barbacana,Cornacas","Taq-i Kisra","Comienzan con +50 de alimento y +50 de madera,Centro urbano y muelle tienen el doble de puntos de resistencia y funcionan 10% en Feudal/15% en Castillos y 20% en Imperial más rápidos","Jinetes +2 ataque contra arqueros"));

        listCivilization.add(new Civilization("Portugueses","Mediterránea","Barcos y unidades de pólvora","Cañon de salvas,Carabela","Carracas,Arcabuz","Torre de Belem","Unidades cuestan -15% oro,Barcos tienen +10 resistencia,Factoría disponible en Edad Imperial","Cartografía gratis desde Edad Media"));

        listCivilization.add(new Civilization("Sarracenos","Medio Oriente","Camellos y naval","Mameluco","Madraza,Fanatismo","Gran Mezquito de Samarra","Mercados cuesten -75 de madera y la tasa cuesta solo 5%,Barcos de transporte doble puntos de resistencia y +5 de capacidad,Galeras atacan 20% más rápido,Arqueros a caballo +3 ataque contra edificios","Arqueros a pie +1 en Feudal/ +2 en Castillos/ +3 en Imperial de ataque contra edificios"));

        listCivilization.add(new Civilization("Tartaros","Asia occidental","Arqueros a caballos","Keshik","Armadura de seda,Tácticas de asedio timuridas","Observatorio de Ulugh Beg","Las unidades hacen +50% de daño por elevación,Obtienen gratis la mejora de Táctica de los partos","Arqueros a caballo +2 línea de visión"));

        listCivilization.add(new Civilization("Teutones","Europa Central","Infanteria","Caballero de la orden Teutónica","Blindaje,Almenas","Abadía de Santa Maria Laach","Centros urbanos guardan +10 unidades,Torres guardan el doble de unidades,Monjes sanan 2 veces mas lejos,Granjas cuestan -33%","Unidades son más resistentes a la conversión"));

        listCivilization.add(new Civilization("Turcos","Medio Oriente","Polvora","Jenizaro","Sipahi,Artillería","Mezquita de Selim","Unidades de pólvora +25% puntos de resistencia y tecnologías de polvora cuestan +50%,Química gratis,Mineros de oro trabajan 20% más rápido,Mejoras de caballería ligera y húsar gratis","Unidades de pólvora son creadas 20% más rápido"));

        listCivilization.add(new Civilization("Vietnamitas","Asia oriental","Arqueros","Arquero de Ratan","Chatras,Papel moneda","Templo But Thap","Posiciones enemigas reveladas desde el inicio de partida,Unidades de la galeria de tiro con arco tienen +20% de resistencia,Leva gratis","Guerrillero imperial disponible en la galería de tiro con arco"));

        listCivilization.add(new Civilization("Vikingos","Europa Central","Infantería y naval","Berserker,Barco Dragón","Hérsires,Trance Frenético","Iglesia de madera Borgound","Barcos de guerra cuestan -10% en feudal/-15% en Castiillos/-20% en Imperial,Carretilla y carro de manos gratis","Muellen cuestan -15%"));



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





}
