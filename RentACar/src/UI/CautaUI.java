package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/10/2016.
 */
public class CautaUI {
    public JFrame frame = new JFrame("-Cauta-");
    JPanel data = new JPanel(new GridLayout(1,8));
    public JPanel rezultat = new JPanel(new GridLayout(5,5));
    JLabel start = new JLabel("Start");
    JLabel sfarsit = new JLabel("End");
    JLabel oras = new JLabel("Oras");
    public JTextField dataB = new JTextField("",JTextField.LEFT);
    public JTextField dataE = new JTextField("",JTextField.LEFT);
    public JTextField city = new JTextField("",JTextField.LEFT);
    JButton submit = new JButton("Catuta");
    JButton back = new JButton("Back");
    public CautaUI(){
        frame.setSize(650,600);
        data.add(start);
        data.add(dataB);
        data.add(sfarsit);
        data.add(dataE);
        data.add(oras);
        data.add(city);
        data.add(submit);
        data.add(back);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(data);
        frame.setVisible(true);
    }
    public void addCautaListener(ActionListener cauta){ submit.addActionListener(cauta); }
    public void addBackListener(ActionListener inapoi){ back.addActionListener(inapoi); }
    public void hide(){ frame.setVisible(false); }
    public void show(){
        frame.setVisible(true);
    }
}
