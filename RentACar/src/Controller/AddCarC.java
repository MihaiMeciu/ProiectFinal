package Controller;


import Client.Client;
import UI.AddCarUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/12/2016.
 */
public class AddCarC {

    private AddCarUI view;

    public AddCarC() {
        this.view = OptionsC.addC;
        view.addBackListener(new BackListener());
        view.addSavaListener(new AddListener());
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String prod = view.prodT.getText();
            String mod = view.modT.getText();
            String an = view.anT.getText();
            String rulaj = view.rulajT.getText();
            String oras = view.orasT.getText();
            String comanda = "addMasina:"+prod+","+mod+","+an+","+rulaj+","+oras;
            Client.client.send(comanda);
        }
    }
}
