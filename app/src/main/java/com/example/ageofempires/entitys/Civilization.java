package com.example.ageofempires.entitys;


import java.io.Serializable;

//Entidad de la BD
public class Civilization implements Serializable {
    private String name_Civi;
    private String arquitectura;
    private String especialidad;
    private String unidad_Unica;
    private String tecnologias;
    private String maravilla;
    private int bonus;
    private String bonus_team;
    private int img;

    //Les pongo INT porque voy a redirigir a un recurso de la carpeta RES, bonus va a estar en Strings y la img en Drawable


    public Civilization() {
    }


    public Civilization(String name_Civi, String arquitectura, String especialidad, String unidad_Unica, String tecnologias, String maravilla, int bonus, String bonus_team, int img) {
        this.name_Civi = name_Civi;
        this.arquitectura = arquitectura;
        this.especialidad = especialidad;
        this.unidad_Unica = unidad_Unica;
        this.tecnologias = tecnologias;
        this.maravilla = maravilla;
        this.bonus = bonus;
        this.bonus_team = bonus_team;
        this.img = img;
    }

    public String getName_Civi() {
        return name_Civi;
    }

    public void setName_Civi(String name_Civi) {
        this.name_Civi = name_Civi;
    }

    public String getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(String arquitectura) {
        this.arquitectura = arquitectura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUnidad_Unica() {
        return unidad_Unica;
    }

    public void setUnidad_Unica(String unidad_Unica) {
        this.unidad_Unica = unidad_Unica;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getMaravilla() {
        return maravilla;
    }

    public void setMaravilla(String maravilla) {
        this.maravilla = maravilla;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getBonus_team() {
        return bonus_team;
    }

    public void setBonus_team(String bonus_team) {
        this.bonus_team = bonus_team;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }





}
