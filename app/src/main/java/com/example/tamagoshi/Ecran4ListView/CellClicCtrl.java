package com.example.tamagoshi.Ecran4ListView;

import android.view.View;
import android.widget.AdapterView;

import com.example.tamagoshi.Manager;

import java.util.Random;

public class CellClicCtrl implements AdapterView.OnItemClickListener {
    private Manager m_M;

    public CellClicCtrl(Manager M) {m_M = M;}
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Object obj = parent.getItemAtPosition(position);
        if(obj instanceof Objet) {
            String s = m_M.getModel().getMasterName() + " a donné un(e) " + ((Objet) obj).getNom() + " à " + m_M.getModel().getName();
            if(((Objet) obj).getPts() < 0){
                s = s + ", il est c'est fait mal";
                m_M.getModel().setMsg(s);
            }else {
                s = s + ", il est plus heureux";
                m_M.getModel().setMsg(s);
            }
            m_M.getModel().setHappyness(m_M.getModel().getHappyness() + ((Objet) obj).getPts());

            m_M.Ecran2();
        }

        if (obj instanceof Nourriture) {
            String s = m_M.getModel().getMasterName() + " a donné un(e) " + ((Nourriture) obj).getNom() + " à manger, " + m_M.getModel().getName() + " se régale";
            m_M.getModel().setMsg(s);
            m_M.getModel().setHungry(m_M.getModel().getHungry() - ((Nourriture) obj).getPts());
            if(position == 12){
                Random rd = new Random();
                if(rd.nextInt(8) == 4){
                    s = m_M.getModel().getName() + " à trouvé la fève dans la " + ((Nourriture) obj).getNom() + ", Il est content";
                }
            }
            m_M.Ecran2();
        }
    }
}
