package Controller;

import Client.*;
import UI.LoginUI;
import UI.OptionsUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by Devene on 5/12/2016.
 */
public class LoginC {

    private LoginUI view;
    protected static OptionsUI op;

    public LoginC() {
        this.view = Client.view;
        view.addSubmitListener(new SubmitListener());
    }

    class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String nume = view.user.getText();
            char[] pas = view.pass.getPassword();
            String pass = String.valueOf(pas);
            String comanda = "login:"+nume+","+pass;
            Client.client.send(comanda);
            try{
                sleep(500);
            }catch(Exception ex){

            }
            String rasp =  Client.raspuns;
            Client.raspuns=null;
            if(rasp!=null){
                String[] val = rasp.split(";");
                rasp=null;
                if(val[1].equals("granted")){
                    view.hide();
                    if(op==null)
                        op = new OptionsUI(val[2]);
                    else
                        op.show();
                    OptionsC opc = new OptionsC(val[2]);
                }
            }
        }
    }
}
