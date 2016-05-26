package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/10/2016.
 */
public class AddCarUI {
    JFrame frame = new JFrame("-New Car-");
    JPanel date = new JPanel(new GridLayout(5,2));
    JPanel butoane = new JPanel(new GridLayout(1,4));
    JLabel prodL = new JLabel("Producator");
    JLabel modL = new JLabel("Model");
    JLabel anL = new JLabel("An fabricatie");
    JLabel rulajL = new JLabel("Km parcursi");
    JLabel orasL = new JLabel("Oras");
    public JTextField prodT = new JTextField("",JTextField.LEFT);
    public JTextField modT = new JTextField("",JTextField.LEFT);
    public JTextField anT = new JTextField("",JTextField.LEFT);
    public JTextField rulajT = new JTextField("",JTextField.LEFT);
    public JTextField orasT = new JTextField("",JTextField.LEFT);
    JButton save = new JButton("Adauga");
    JButton back = new JButton("Back");
    public AddCarUI(){
        frame.setSize(650,600);
        date.add(prodL);
        date.add(prodT);
        date.add(modL);
        date.add(modT);
        date.add(anL);
        date.add(anT);
        date.add(rulajL);
        date.add(rulajT);
        date.add(orasL);
        date.add(orasT);
        butoane.add(save);
        butoane.add(back);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }
    public void addSavaListener(ActionListener submit){ save.addActionListener(submit);}
    public void addBackListener(ActionListener inapoi){ back.addActionListener(inapoi);}
    public void hide(){ frame.setVisible(false); }
    public void show(){
        frame.setVisible(true);
    }
}
