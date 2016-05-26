package Client;

import Controller.LoginC;
import Observers.CautaObserver;
import Observers.LoginObserver;
import Observers.Observer;
import Observers.RezervariObserver;
import UI.LoginUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devene on 5/12/2016.
 */
public class Client {

    private ObjectInputStream intrare;
    private ObjectOutputStream iesire;
    private Socket socket;
    public static LoginUI view;
    public static Client client;
    private List<Observer> obss = new ArrayList<Observer>();
    public static String raspuns;

    private String server,username;
    private int port;

    Client(String server, int port, String username){
        this.server = server;
        this.port = port;
        this.username = username;
    }
    public boolean start(){
        try{
            socket = new Socket(server,port);
        }catch(Exception ex){
            return false;
        }
        try{
            intrare = new ObjectInputStream(socket.getInputStream());
            iesire = new ObjectOutputStream(socket.getOutputStream());
        }catch(IOException ex){
            return false;
        }
        new ListenFromServer().start();
        try{
            iesire.writeObject(username);
        }catch(IOException ex){
            System.out.print("eroare conexiune");
            disconect();
            return false;
        }
        return true;
    }
    public boolean send(String com){
        try{
            iesire.writeObject(com);
            iesire.flush();
        }catch(IOException ex){
            return false;
        }
        return true;
    }
    private void disconect(){
        try{
            if(intrare!=null) intrare.close();
        }catch(Exception ex){}
        try{
            if(iesire!=null) iesire.close();
        }catch(Exception ex){}
        try{
            if(socket!=null) socket.close();
        }catch(Exception ex){}
    }

    public static void main(String[] args){
        int port = 50000;
        String serverName = "localhost";
        client = new Client(serverName,port,"client");
        if(!client.start())
            return;
        new CautaObserver(client);
        new LoginObserver(client);
        new RezervariObserver(client);
        view = new LoginUI();
        LoginC cont = new LoginC();
    }
    public void attach(Observer obs){
        obss.add(obs);
    }

    class ListenFromServer extends Thread{

        public void run(){
            while (true){
                try {
                    raspuns = (String) intrare.readObject();
                    if (raspuns!=null){
                        String[] mesaj=raspuns.split(";");
                        switch (mesaj[0]){
                            case "login":{
                                for(Observer o:obss){
                                    if(o instanceof LoginObserver)
                                        o.update();
                                }
                                break;
                            }
                            case "cauta":{
                                for(Observer o:obss){
                                    if(o instanceof CautaObserver)
                                        o.update();
                                }
                                break;
                            }
                            case "rezervari":{
                                for(Observer o:obss){
                                    if(o instanceof RezervariObserver)
                                        o.update();
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }catch(IOException ex){
                    break;
                }catch(ClassNotFoundException ex){
                }
            }
        }
    }
}
