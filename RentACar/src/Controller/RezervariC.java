package Controller;

import Client.Client;
import Client.Rezervare;
import UI.RezervariUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by Devene on 5/12/2016.
 */
public class RezervariC {

    private RezervariUI view;

    public RezervariC() {
        this.view = OptionsC.reze;
        view.addRefListener(new RefreshListener());
        view.addBackListener(new BackListener());
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String comanda = "rezerv:";
            Client.client.send(comanda);
            try{
                sleep(500);
            }catch(Exception ex){

            }
            String rasp = Client.raspuns;
            Client.raspuns=null;
            if(rasp!=""){
                String[] rez = rasp.split(";");
                view.rezultat.removeAll();
                for(String reze:rez) {
                    String[] date = reze.split(",");
                    JButton but = new JButton(date[2] + "-" + date[3] + " " + date[0]);
                    but.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Rezervare.createDoc(reze);
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
