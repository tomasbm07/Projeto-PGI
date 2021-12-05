package com.example.pgi_app;

import java.io.Serializable;
import java.util.ArrayList;

public class Planta implements Serializable {

    public static ArrayList<Planta> plantList = new ArrayList<Planta>();

    @Override
    public String toString() {
        return  nome ;
    }

    public static ArrayList<Planta> minhaHorta = new ArrayList<Planta>();


    private String nome;
    private String description;
    private String cuidados;
    private float[] nutriValues;
    private int image;

    public Planta(String nome, String description, String cuidados, float[] nutriValues, int image) {
        this.description = description;
        this.cuidados = cuidados;
        this.nome = nome;
        this.nutriValues = nutriValues;
        this.image = image;
    }

    static public Planta getPlanta(String name) {
        for (Planta item : plantList) {
            if (item.getNome().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float[] getNutriValues() {
        return nutriValues;
    }

    public void setNutriValues(float[] nutriValues) {
        this.nutriValues = nutriValues;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
