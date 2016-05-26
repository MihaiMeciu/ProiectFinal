package Logic;

import DBInteractions.RezGateway;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Devene on 5/17/2016.
 */
public class Rezervare {
    private String cont;
    private Masina mas;
    private String dataB;
    private String dataE;
    private String timp;

    public String getCont(){return cont;}
    public String getDataB(){return dataB;}
    public String getDataE(){return dataE;}
    public Masina getMas(){return mas;}
    public String getTimp(){return timp;}

    public Rezervare(String cont,Masina mas,String dataB,String dataE,String timp){
        this.cont = cont;
        this.mas = mas;
        this.dataB = dataB;
        this.dataE = dataE;
        this.timp = timp;
    }
    public static void rezerva(String rez){
        RezGateway gate = new RezGateway();
        String[] date = rez.split(";");
        String[] user = date[0].split(",");
        String cont = user[0]+","+user[1];
        String[] masina = date[1].split(",");
        Masina mas = new Masina(masina[0],masina[1],masina[2],masina[5]);
        Rezervare nou = new Rezervare(cont,mas,date[2],date[3],date[4]);
        gate.rezerva(nou);
        nou.sendEmail(date[0],mas);
    }
    public static String getRezActive(){
        RezGateway gate = new RezGateway();
        return gate.findRez();
    }
    protected void sendEmail(String email,Masina mas){
        String from = "cars@cars.com";
        String host = "localhost";
        Properties prop = System.getProperties();
        prop.setProperty("maail.smtp.host",host);
        Session session = Session.getDefaultInstance(prop);
        try{
            MimeMessage mesaj = new MimeMessage(session);
            mesaj.setFrom(new InternetAddress(from));
            mesaj.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            mesaj.setSubject("Rezervarea dumneavoastra.");
            mesaj.setText("Va multumim ca ati ales serviciul nostru. \nRezervarea pentru  "+mas.getProducator()+" - "+mas.getModel()+" a fost procesata, va asteptam la sediu pentru a ridica masina.\nCu stima Cars for Reent!");
            Transport.send(mesaj);
        }catch(MessagingException ex){

        }
    }
}
