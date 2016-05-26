package Controller;

import Client.Client;
import UI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 5/12/2016.
 */
public class OptionsC {
    private OptionsUI view;
    protected static AddCarUI addC;
    protected static AddClientUI addCl;
    protected static AddEmployeeUI addE;
    protected static CautaUI cauta;
    protected static RezervariUI reze;
    protected static ModificareUserUI modifU;
    protected static ModificareCarUI modifC;
    private String nume;


    public OptionsC(String nume){
        this.view = LoginC.op;
        view.addCautaListener(new CautaListener());
        view.addAngajatListener(new AngajatiListener());
        view.addClientListener(new ClientiListener());
        view.addMasinaListener(new MasinaListener());
        view.addOutListener(new BackListener());
        view.addRezervListener(new RezListener());
        view.addModUListener(new ModifUListener());
        view.addModCListener(new ModifCListener());
        this.nume = nume;
    }

    class CautaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(cauta==null){
                cauta = new CautaUI();
                CautaC caut = new CautaC(nume);
            }else{
                cauta.show();
            }
        }
    }
    class AngajatiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(addE==null){
                addE = new AddEmployeeUI();
                AddEmployeeC newE = new AddEmployeeC();
            }else{
                addE.show();
            }
        }
    }
    class ClientiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(addCl==null){
                addCl = new AddClientUI();
                AddClientC newCl = new AddClientC();
            }else{
                addCl.show();
            }
        }
    }
    class MasinaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(addC==null){
                addC = new AddCarUI();
                AddCarC newC = new AddCarC();
            }else{
                addC.show();
            }
        }
    }
    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            Client.view.show();
            LoginC.op.clear();
            LoginC.op=null;
            addC=null;
            addCl=null;
            addE=null;
            cauta=null;
            reze=null;
            modifC=null;
            modifU=null;
        }
    }
    class RezListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(reze==null){
                reze = new RezervariUI();
                RezervariC rez = new RezervariC();
            }else{
                reze.show();
            }
        }
    }
    class ModifUListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(modifU==null){
                modifU = new ModificareUserUI();
                ModificareUserC modiU = new ModificareUserC();
            }else{
                modifU.show();
            }
        }
    }
    class ModifCListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.hide();
            if(modifC==null){
                modifC = new ModificareCarUI();
                ModificareCarC modiC = new ModificareCarC();
            }else{
                modifC.show();
            }
        }
    }
}
