package Controller;

import Client.*;
import UI.ModificareCarUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by Devene on 5/18/2016.
 */
public class ModificareCarC {
    private ModificareCarUI view;

    public ModificareCarC(){
        this.view = OptionsC.modifC;
        view.addBackListener(new BackListener());
        view.addCautaListener(new CautaListener());
        view.addUpdateListener(new SaveListener());
    }
    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class CautaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String prod  = view.prod.getText();
            String model = view.model.getText();
            String anF = view.anF.getText();
            String comanda = "cautaMasina:"+","+prod+","+model+","+anF;
            Client.client.send(comanda);
            try{
                sleep(500);
            }catch(Exception ex){

            }
            String rasp =  Client.raspuns;
            Client.raspuns=null;
            if(rasp!=null){
                String[] date = rasp.split(",");
                view.oras.setText(date[0]);
                view.rulaj.setText(date[1]);
                view.status.setSelectedItem(date[2]);
                view.prod.setEditable(false);
                view.model.setEditable(false);
                view.anF.setEditable(false);
            }
        }
    }
    class SaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String oras = view.oras.getText();
            String rul = view.rulaj.getText();
            String status = (String) view.status.getSelectedItem();
            String prod  = view.prod.getText();
            String model = view.model.getText();
            String anF = view.anF.getText();
            String comanda = "updateMasina:"+prod+","+model+","+anF+","+rul+","+oras+","+status;
            Client.client.send(comanda);
        }
    }
}
