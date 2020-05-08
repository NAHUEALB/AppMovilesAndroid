package com.example.ageofempires.entitys;


import java.io.Serializable;

//Entidad de la BD
public class Civilization implements Serializable {
    private Integer id_Civi;
    private String name_Civi;
    private String arquitectura;
    private String especialidad;
    private String unidad_Unica;
    private String tecnologias;
    private String maravilla;
    private String bonus;
    private String bonus_team;




    public Civilization(Integer id_Civi, String name_Civi, String arquitectura, String especialidad, String unidad_Unica, String tecnologias, String maravilla, String bonus, String bonus_team) {
        this.id_Civi = id_Civi;
        this.name_Civi = name_Civi;
        this.arquitectura = arquitectura;
        this.especialidad = especialidad;
        this.unidad_Unica = unidad_Unica;
        this.tecnologias = tecnologias;
        this.maravilla = maravilla;
        this.bonus = bonus;
        this.bonus_team = bonus_team;
    }

    public Civilization(){

    }


    public Integer getId_Civi() {
        return id_Civi;
    }

    public void setId_Civi(Integer id_Civi) {
        this.id_Civi = id_Civi;
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

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getBonus_team() {
        return bonus_team;
    }

    public void setBonus_team(String bonus_team) {
        this.bonus_team = bonus_team;
    }



}
