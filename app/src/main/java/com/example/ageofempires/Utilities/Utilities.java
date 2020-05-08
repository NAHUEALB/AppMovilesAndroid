package com.example.ageofempires.Utilities;


//Esta clase sera para almacenar Constantes globales a la aplicacion

public class Utilities {

    //Cte de campos de la BD
    public static final String TABLA_CIVILIZATION = "civilization";
    public static final String CAMPO_ID_CIVI = "id_Civi";
    public static final String CAMPO_NAME_CIVI = "name_Civi";
    public static final String CAMPO_ARQUITECTURA = "arquitectura";
    public static final String CAMPO_ESPECIALIDAD = "especialidad";
    public static final String CAMPO_UNIDAD_UNICA = "unidad_Unica";
    public static final String CAMPO_TECNOLOGIAS = "tecnologias";
    public static final String CAMPO_MARAVILLA = "maravilla";
    public static final String CAMPO_BONUS = "bonus";
    public static final String CAMPO_BONUS_TEAM = "bonus_team";

    public static final String TABLE_CREATE = "CREATE TABLE "+ TABLA_CIVILIZATION +" ("+ CAMPO_ID_CIVI +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ CAMPO_NAME_CIVI +" TEXT, "+ CAMPO_ARQUITECTURA +" TEXT, "
            + CAMPO_ESPECIALIDAD +" TEXT, "+ CAMPO_UNIDAD_UNICA +" TEXT, "+ CAMPO_TECNOLOGIAS +" TEXT,"+ CAMPO_MARAVILLA +" TEXT, "+ CAMPO_BONUS +" TEXT, "+ CAMPO_BONUS_TEAM +" TEXT)";



}
