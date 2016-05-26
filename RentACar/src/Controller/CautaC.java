package Controller;

import Client.*;
import UI.CautaUI;
import UI.FormUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * Created by Devene on 5/12/2016.
 */
public class CautaC {

    private CautaUI view;
    protected static FormUI form;
    private String nume;

    public CautaC(String nume) {
        this.view = OptionsC.cauta;
        view.addBackListener(new BackListener());
        view.addCautaListener(new CautaListener());
        form=null;
        this.nume = nume;
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class CautaListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String dataB = view.dataB.getText();
            String dataE = view.dataE.getText();
            String city = view.city.getText();
            String comanda = "cauta:"+dataB+","+dataE+","+city;
            Client.client.send(comanda);
            try{
                sleep(500);
            }catch(Exception ex){

            }
            String rasp =  Client.raspuns;
            Client.raspuns=null;
            if(rasp!=null){
                String[] masini = rasp.split(";");
                view.rezultat.removeAll();
                for(String mas:masini) {
                    String[] date = mas.split(",");
                    JButton but = new JButton(date[0] + " " + date[1]);
                    but.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            view.hide();
                            if (form == null) {
                                form = new FormUI(mas, nume);
                                FormC formC = new FormC();
                            } else {
                                form.show();
                            }
                        }
                    });
                    view.rezultat.add(but);
                }
                view.frame.getContentPane().add(view.rezultat);
                view.frame.setVisible(true);
            }
        }
    }
}
