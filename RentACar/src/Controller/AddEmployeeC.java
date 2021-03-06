package Controller;

import Client.Client;

import UI.AddEmployeeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/12/2016.
 */
public class AddEmployeeC {

    private AddEmployeeUI view;

    public AddEmployeeC() {
        this.view = OptionsC.addE;
        view.addBackListener(new BackListener());
        view.addNewListener(new AddListener());
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String nume = view.numeT.getText();
            char[] pas1 = view.pass1F.getPassword();
            char[] pas2 = view.pass2F.getPassword();
            String email = view.emailT.getText();
            String pass1 = String.valueOf(pas1);
            String pass2 = String.valueOf(pas2);
            if(pass1.equals(pass2)){
                String comanda = "addEmployee:"+nume+","+pass1+","+email+",empl";
                Client.client.send(comanda);
            }
        }
    }
}
