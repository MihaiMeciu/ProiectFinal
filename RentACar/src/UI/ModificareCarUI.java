package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/18/2016.
 */
public class ModificareCarUI {

    JFrame frame = new JFrame("-Modificare Cont-");
    JPanel date = new JPanel(new GridLayout(7,2));
    JPanel butoane = new JPanel(new GridLayout(1,3));
    JButton save = new JButton("Save");
    JButton back = new JButton("Back");
    JButton cauta = new JButton("Cauta");
    JLabel prodL = new JLabel("Producator");
    JLabel modL = new JLabel("Model");
    JLabel anFL = new JLabel("An fabricatie");
    JLabel rulajL = new JLabel("Rulaj");
    JLabel poze = new JLabel("Poze");
    JLabel orasL = new JLabel("Oras");
    JLabel rezL = new JLabel("Status");
    public JTextField prod = new JTextField("",JTextField.LEFT);
    public JTextField model = new JTextField("",JTextField.LEFT);
    public JTextField anF = new JTextField("",JTextField.LEFT);
    public JTextField rulaj = new JTextField("",JTextField.LEFT);
    public JTextField oras = new JTextField("",JTextField.LEFT);
    String[] op={"Rezervat","Nerezervat"};
    public JComboBox status = new JComboBox(op);

    public ModificareCarUI(){
        frame.setSize(650,600);
        date.add(prodL);
        date.add(prod);
        date.add(modL);
        date.add(model);
        date.add(anFL);
        date.add(anF);
        date.add(rulajL);
        date.add(rulaj);
        date.add(orasL);
        date.add(oras);
        date.add(rezL);
        date.add(status);
        date.add(poze);
        butoane.add(back);
        butoane.add(cauta);
        butoane.add(save);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }

    public void addCautaListener(ActionListener caut) { cauta.addActionListener(caut);}
    public void addUpdateListener(ActionListener salveaza){ save.addActionListener(salveaza); }
    public void addBackListener(ActionListener inapoi){ back.addActionListener(inapoi); }
    public void hide(){ frame.setVisible(false); }
    public void show(){
        frame.setVisible(true);
    }
}
