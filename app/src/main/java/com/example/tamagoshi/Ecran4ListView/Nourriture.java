package com.example.tamagoshi.Ecran4ListView;

import java.util.ArrayList;

public class Nourriture extends Object {
    private String m_nomnour;
    private int m_point;

    private static ArrayList<Nourriture> listobj;

    public Nourriture(String nom, int point){
        this.m_nomnour = nom;
        this.m_point = point;
    }

    public String getNom() {return m_nomnour;}
    public int getPts() {return m_point;}

    public static ArrayList<Nourriture> getListnrt(){
        if(listobj == null){
            listobj = new ArrayList<Nourriture>();

            listobj.add(new Nourriture("Patées pour Tamagoshi", 6));
            listobj.add(new Nourriture("Un gros tacos", 10));
            listobj.add(new Nourriture("Glace", 8));
            listobj.add(new Nourriture("Spaghetti Bolognaise", 7));
            listobj.add(new Nourriture("Pancakes", 6));
            listobj.add(new Nourriture("Salade", 4));
            listobj.add(new Nourriture("Pizza", 9));
            listobj.add(new Nourriture("Lasagne", 12));
            listobj.add(new Nourriture("Raclette", 15));
            listobj.add(new Nourriture("Cacahuète", 1));
            listobj.add(new Nourriture("Chips", 2));
            listobj.add(new Nourriture("Hamburger", 8));
            listobj.add(new Nourriture("Galette des rois", 13));
        }
        return listobj;
    }
}
