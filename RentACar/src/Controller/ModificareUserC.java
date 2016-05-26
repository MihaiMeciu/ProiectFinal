package Controller;

import Client.*;
import UI.ModificareUserUI;

import javax.jws.soap.SOAPBinding;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by Devene on 5/18/2016.
 */
public class ModificareUserC {
    private ModificareUserUI view;
    private User user;

    public ModificareUserC(){
        this.view = OptionsC.modifU;
        view.addBackListener(new BackListener());
        view.addCautaListener(new CautaListener());
        view.addUpdateListener(new SaveListener());
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class CautaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String nume  = view.nume.getText();
            String comanda = "cautaUser:"+nume;
            Client.client.send(comanda);
            try{
                sleep(500);
            }catch(Exception ex){

            }
            String rasp =  Client.raspuns;
            Client.raspuns=null;
            if(rasp!=null){
                String[] date = rasp.split(",");
                user = new User(date[0],date[1],date[2],date[3]);
                view.email.setText(user.getEmail());
                view.nume.setEditable(false);
            }
        }
    }
    class SaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String email = view.email.getText();
            char[] pasV = view.pasV.getPassword();
            char[] pas1 = view.pas1.getPassword();
            char[] pas2 = view.pas2.getPassword();
            String passV = String.valueOf(pasV);
            String pass1 = String.valueOf(pas1);
            String pass2 = String.valueOf(pas2);
            if(user!=null){
                if(passV.equals(user.getParola())){
                    if(pass1.equals(pass2)){
                        String comanda = "updateUser:"+","+user.getNume()+","+email+","+pass1+","+user.getTip();
                        Client.client.send(comanda);
                    }
                }else{
                    String comanda = "updateUser:"+","+user.getNume()+","+email+","+user.getParola()+","+user.getTip();
                    Client.client.send(comanda);
                }
            }
        }
    }
}
