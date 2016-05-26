package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/10/2016.
 */
public class OptionsUI {
    static JFrame frame = new JFrame("-Optiuni-");
    JPanel butoane = new JPanel(new GridLayout(3,3));
    JButton cauta = new JButton("Cauta masini");
    JButton addC = new JButton("Adauga Clienti");
    JButton addM = new JButton("Adauga Masini");
    JButton addE = new JButton("Adauga Angajati");
    JButton rezerv = new JButton("Contracte");
    JButton modU = new JButton("Modifica users");
    JButton modC = new JButton("Modificare Masini");
    JButton out = new JButton("Logout");

    public OptionsUI(String tip){
        frame.setSize(650,600);
        butoane.removeAll();
        String[] val = tip.split(",");
        switch (val[2].toLowerCase()) {
            case "client":{
                butoane.add(cauta);
                butoane.add(out);
                break;
            }
            case "empl":{
                butoane.add(rezerv);
                butoane.add(out);
                break;
            }
            case "adm":{
                butoane.add(addC);
                butoane.add(addM);
                butoane.add(addE);
                butoane.add(out);
                butoane.add(modU);
                butoane.add(modC);
                break;
            }
            default: {
                butoane.add(out);
                break;
            }
        }
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }
    public void addCautaListener(ActionListener search) { cauta.addActionListener(search);}
    public void addClientListener(ActionListener client) { addC.addActionListener(client);}
    public void addMasinaListener(ActionListener masina) { addM.addActionListener(masina);}
    public void addAngajatListener(ActionListener angajat) { addE.addActionListener(angajat);}
    public void addRezervListener(ActionListener rez) { rezerv.addActionListener(rez);}
    public void addOutListener(ActionListener exit) { out.addActionListener(exit);}
    public void addModUListener(ActionListener modif) { modU.addActionListener(modif);}
    public void addModCListener(ActionListener modifC) { modC.addActionListener(modifC);}
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){
        frame.setVisible(true);
    }
    public void clear() { frame.removeAll(); }
}
