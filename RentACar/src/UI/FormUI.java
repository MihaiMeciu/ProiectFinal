package UI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/12/2016.
 */
public class FormUI {
    JFrame frame = new JFrame("-Formular-");
    JPanel date = new JPanel(new GridLayout(5,2));
    JPanel butoane = new JPanel(new GridLayout(1,2));
    JLabel prod;
    JLabel mod;
    JLabel anF;
    JLabel rulaj;
    JLabel nume;
    JLabel dataI = new JLabel("Data ridicarii");
    JLabel dataS = new JLabel("Data returnarii");
    JLabel nimic = new JLabel("");
    public JTextField dataB = new JTextField("",JTextField.LEFT);
    public JTextField dataE = new JTextField("",JTextField.LEFT);
    JButton submit = new JButton("Rezerva");
    JButton back = new JButton("Back");
    private String cont;
    private String masina;
    public FormUI(String mas,String nume){
        this.cont=nume;
        this.masina = mas;
        String[] dateM = masina.split(",");
        frame.setSize(650,600);
        prod = new JLabel(dateM[0]);
        mod = new JLabel(dateM[1]);
        anF = new JLabel(dateM[2]);
        rulaj = new JLabel(dateM[4]);
        String[] val = nume.split(",");
        this.nume = new JLabel(val[0]);
        date.add(prod);
        date.add(mod);
        date.add(anF);
        date.add(rulaj);
        date.add(this.nume);
        date.add(nimic);
        date.add(dataI);
        date.add(dataB);
        date.add(dataS);
        date.add(dataE);
        butoane.add(submit);
        butoane.add(back);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }
    public void addRezListener(ActionListener rez){ submit.addActionListener(rez); }
    public void addBackListener(ActionListener inapoi){ back.addActionListener(inapoi); }
    public void hide(){ frame.setVisible(false); }
    public void show(){
        frame.setVisible(true);
    }
    public String getCont(){ return cont; }
    public String getMasina(){ return  masina; }
}
