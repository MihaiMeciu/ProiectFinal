package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/18/2016.
 */
public class ModificareUserUI {
    JFrame frame = new JFrame("-Modificare Cont-");
    JPanel date = new JPanel(new GridLayout(5,2));
    JPanel butoane = new JPanel(new GridLayout(1,3));
    JButton save = new JButton("Save");
    JButton back = new JButton("Back");
    JButton cauta = new JButton("Cauta");
    JLabel numeL = new JLabel("Nume");
    JLabel emailL = new JLabel("Email");
    JLabel pasVL = new JLabel("Parola veche");
    JLabel pas1L = new JLabel("Parola noua");
    JLabel pas2L = new JLabel("Reintroduceti parola");
    public JTextField nume = new JTextField("",JTextField.LEFT);
    public JTextField email = new JTextField("",JTextField.LEFT);
    public JPasswordField pasV = new JPasswordField();
    public JPasswordField pas1 = new JPasswordField();
    public JPasswordField pas2 = new JPasswordField();

    public ModificareUserUI(){
        frame.setSize(650,600);
        date.add(numeL);
        date.add(nume);
        date.add(emailL);
        date.add(email);
        date.add(pasVL);
        date.add(pasV);
        date.add(pas1L);
        date.add(pas1);
        date.add(pas2L);
        date.add(pas2);
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
