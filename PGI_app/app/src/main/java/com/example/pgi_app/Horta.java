package com.example.pgi_app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Horta implements Serializable {
    private Planta p;
    private int image;
    public static ArrayList<Horta> Hortas;
    Date data = new Date();

    public Horta(com.example.pgi_app.Planta p, int image) {
        this.p = p;
        this.image = image;
        this.data = new Date();
    }

    public com.example.pgi_app.Planta getP() {
        return p;
    }

    public void setP(com.example.pgi_app.Planta p) {
        this.p = p;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<Horta> getHortas() {
        return Hortas;
    }

    public static void setHortas(ArrayList<Horta> hortas) {
        Hortas = hortas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Horta{" +
                "p=" + p +
                ", image='" + image + '\'' +
                ", data=" + data +
                '}';
    }
}
