package Server;

import DBInteractions.CarGateway;
import DBInteractions.UserGateway;
import Logic.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Devene on 5/12/2016.
 */
public class Server {

    private static int idU;
    private static Server server;
    public static ClientThread cl;
    private int port;
    private boolean on;

    public Server(int port){
        this.port = port;
    }
    public void start(){
        on=true;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (on) {
                if(!on) {
                    break;
                }
                    Socket socket = serverSocket.accept();
                    cl = new ClientThread(socket);
                    cl.start();
            }
            try{
                serverSocket.close();
                try{
                    cl.intrare.close();
                    cl.iesire.close();
                    cl.socket.close();
                }catch(IOException ex){}
            }catch(Exception ex){}
        }catch(IOException ex){}
    }

    public static void main(String[] args){
        int port=50000;
        server = new Server(port);
        server.start();
    }
    class ClientThread extends Thread{
        Socket socket;
        ObjectInputStream intrare;
        ObjectOutputStream iesire;
        String com;

        ClientThread(Socket socket){
            this.socket = socket;
            try{
                iesire = new ObjectOutputStream(socket.getOutputStream());
                //iesire.flush();
                intrare = new ObjectInputStream(socket.getInputStream());
                String username = (String) intrare.readObject();
                System.out.print(username);
            }catch(IOException ex){
                return;
            }catch (ClassNotFoundException e){

            }
        }
        public void run(){
            boolean on = true;

            while(on){
                try {
                    com =  (String) intrare.readObject();
                }catch(IOException e) {
                    e.printStackTrace();
                    System.out.print("ioexception");
                    break;
                }catch(ClassNotFoundException e) {
                    System.out.print("class not found exception");
                    break;
                }
                String[] mesaj = com.split(":");
                switch (mesaj[0]) {
                    case "addMasina": {
                        Masina.insert(mesaj[1]);
                        break;
                    }
                    case "addClient": {
                        User.insert(mesaj[1]);
                        break;
                    }
                    case "addEmployee": {
                        User.insert(mesaj[1]);
                        break;
                    }
                    case "cauta": {
                        String lista =  Masina.findCars(mesaj[1]);
                        send(lista);
                        break;
                    }
                    case "rezerva": {
                        Rezervare.rezerva(mesaj[1]);
                        break;
                    }
                    case "login": {
                        String[] val = mesaj[1].split(",");
                        User acces = User.acces(val[0],val[1]);
                        if (acces!=null){
                            String rasp = "login;granted;"+acces.getNume()+","+acces.getEmail()+","+acces.getTip();
                            send(rasp);
                        }
                        break;
                    }
                    case "rezerv": {
                        String list = Rezervare.getRezActive();
                        send(list);
                        break;
                    }
                    case "cautaMasina":{
                        String[] date = mesaj[1].split(",");
                        Masina rez = Masina.find(date[1],date[2],date[3]);
                        String raspuns = rez.getOras()+","+Integer.toString(rez.getRulaj())+","+rez.getStatus();
                        send(raspuns);
                        break;
                    }
                    case "updateMasina":{
                        Masina.update(mesaj[1]);
                        break;
                    }
                    case "cautaUser":{
                        User rez = User.find(mesaj[1]);
                        String rezultat = rez.getNume()+","+rez.getParola()+","+rez.getEmail()+","+rez.getTip();
                        send(rezultat);
                        break;
                    }
                    case "updateUser":{
                        User.update(mesaj[1]);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            close();
        }
        private void close(){
            try{
                if(intrare != null) intrare.close();
            }catch (Exception ex){}
            try{
                if(iesire != null) iesire.close();
            }catch (Exception ex){}
            try{
                if(socket != null) socket.close();
            }catch (Exception ex){}
        }
        boolean send(String rasp){
            if(!socket.isConnected()){
                close();
                return false;
            }
            try{
                iesire.writeObject(rasp);
                iesire.flush();
            }catch(IOException ex){

            }
            return true;
        }
    }
}
