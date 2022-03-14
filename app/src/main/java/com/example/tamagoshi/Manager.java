package com.example.tamagoshi;

import android.content.Context;

import com.example.tamagoshi.Ecran1.Accueil;
import com.example.tamagoshi.Ecran1.AccueilCtrl;
import com.example.tamagoshi.Ecran2.Interaction;
import com.example.tamagoshi.Ecran4ListView.Nourriture;
import com.example.tamagoshi.Ecran4ListView.Objet;
import com.example.tamagoshi.Ecran4ListView.ListViewClass;
import com.example.tamagoshi.Ecran2.TamagoshiView;
import com.example.tamagoshi.Ecran3.ConfigCtrl;
import com.example.tamagoshi.Ecran3.Configuration;

import java.util.ArrayList;


public class Manager {
    private ArrayList<Objet> m_listobj;
    private ArrayList<Nourriture> m_listnour;
    private ArrayList<Object> m_list;
    private MainActivity m_refMA;
    private Accueil m_V1;
    private AccueilCtrl m_C1;
    private TamagoshiView m_V2;
    private Tamagoshi m_M;
    private Interaction m_C2;
    private ConfigCtrl m_C3;
    private Configuration m_V3;
    private ListViewClass m_V4;
    private static Manager instance = null;
    private Context context;

    private Manager(Context c, MainActivity MA){
        context = c;
        m_refMA = MA;
        m_C1 = new AccueilCtrl(this);
        m_V1 = new Accueil(context, m_C1);
        m_C1.setRefV(m_V1);
        m_M = new Tamagoshi();
        m_C2 = new Interaction(m_M, this);
        m_V2 = new TamagoshiView(context, m_C2, m_M);
        m_C2.setRefV(m_V2);
        m_M.addObserver(m_V2);
        m_C3 = new ConfigCtrl(m_M, this);
        m_V3 = new Configuration(context, m_C3, m_M);
        m_C3.setRefV(m_V3);
        m_listobj = Objet.getListobj();
        m_listnour = Nourriture.getListnrt();
    }

    public static Manager getInstance(Context context, MainActivity MA){
        if(instance == null){
            instance = new Manager(context, MA);
        }
        return instance;
    }

    public void Ecran1(){ m_refMA.setContentView(m_V1); }
    public void Ecran2(){ m_refMA.setContentView(m_V2); }
    public void Ecran3(){ m_refMA.setContentView(m_V3); }

    public Tamagoshi getModel(){return m_M;}
    public MainActivity getActivity(){return m_refMA;}

    public void EcranObjet(){
        m_list = new ArrayList<>(m_listobj);
        m_V4 = new ListViewClass(this, context, m_list);
        m_refMA.setContentView(m_V4);
    }

    public void EcranNourriture() {
        m_list = new ArrayList<>(m_listnour);
        m_V4 = new ListViewClass(this, context, m_list);
        m_refMA.setContentView(m_V4);
    }

}
