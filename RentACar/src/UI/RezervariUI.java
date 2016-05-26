package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/10/2016.
 */
public class RezervariUI {
    public JFrame frame = new JFrame("-Rezervari-");
    JPanel rez = new JPanel(new GridLayout(1,2));
    public JPanel rezultat = new JPanel(new GridLayout(1,1));
    JButton refresh = new JButton("Refresh");
    JButton back = new JButton("Back");
    public RezervariUI(){
        frame.setSize(650,600);
        rez.add(refresh);
        rez.add(back);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(rez);
        frame.setVisible(true);
    }
    public void addRefListener(ActionListener ref){ refresh.addActionListener(ref);}
    public void addBackListener(ActionListener inapoi){ back.addActionListener(inapoi);}
    public void hide(){ frame.setVisible(false); }
    public void show(){
        frame.setVisible(true);
    }
}
