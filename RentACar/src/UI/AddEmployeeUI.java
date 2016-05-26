package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/10/2016.
 */
public class AddEmployeeUI {
    JFrame frame = new JFrame("New Client-");
    JPanel date = new JPanel(new GridLayout(4,2));
    JPanel butoane = new JPanel(new GridLayout(2,1));
    JButton add = new JButton("Adauga");
    JButton back = new JButton("Back");
    JLabel numeL = new JLabel("Nume");
    JLabel pass1L = new JLabel("Parola");
    JLabel pass2L = new JLabel("Reintroduceti parola");
    JLabel emailL = new JLabel("Email");
    public JTextField numeT = new JTextField("",JTextField.LEFT);
    public JPasswordField pass1F = new JPasswordField(15);
    public JPasswordField pass2F = new JPasswordField(15);
    public JTextField emailT = new JTextField("",JTextField.LEFT);

    public AddEmployeeUI () {
        frame.setSize(650,600);
        date.add(numeL);
        date.add(numeT);
        date.add(emailL);
        date.add(emailT);
        date.add(pass1L);
        date.add(pass1F);
        date.add(pass2L);
        date.add(pass2F);
        butoane.add(add);
        butoane.add(back);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }
    public void addNewListener(ActionListener client) {
        add.addActionListener(client);
    }
    public void addBackListener(ActionListener exit) { back.addActionListener(exit);}
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){
        frame.setVisible(true);
    }
}
