package Controller;

import Client.Client;

import UI.FormUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Devene on 5/12/2016.
 */
public class FormC {
    private FormUI view;

    public FormC(){
        this.view = CautaC.form;
        view.addBackListener(new BackListener());
        view.addRezListener(new RezListener());
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class RezListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String dataB = view.dataB.getText();
            String dataE = view.dataE.getText();
            String cont = view.getCont();
            String mas = view.getMasina();
            Calendar cal = Calendar.getInstance();
            Timestamp timp = new Timestamp(cal.getTime().getTime());
            String data = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(timp);
            String comanda = "rezerva:"+cont+";"+mas+";"+dataB+";"+dataE+";"+data;
            Client.client.send(comanda);
        }
    }
}
