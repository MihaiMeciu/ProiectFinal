package Logic;

import DBInteractions.UserGateway;

/**
 * Created by Devene on 5/12/2016.
 */
public class User {
    private String nume;
    private String parola;
    private String email;
    private String tip;

    public User(String nume,String parola, String email,String tip){
        this.nume = nume;
        this.parola = parola;
        this.email = email;
        this.tip = tip;
    }
    public static void insert(String cont){
        UserGateway gate = new UserGateway();
        String[] date = cont.split(",");
        User nou = new User(date[0],date[1],date[2],date[3]);
        gate.insert(nou);
    }
    public static User find(String cont){
        UserGateway gate = new UserGateway();
        User rez = gate.find(cont);
        if(rez==null) return null;
        else return rez;
    }
    public static User acces(String nume,String parola){
        UserGateway gate = new UserGateway();
        return gate.acces(nume,parola);
    }
    public static void update(String user){
        String[] val = user.split(",");
        User nou = new User(val[1],val[3],val[2],val[4]);
        UserGateway gate = new UserGateway();
        gate.update(nou);
    }
    public String getNume(){
        return nume;
    }
    public String getParola(){
        return parola;
    }
    public String getEmail(){
        return email;
    }
    public String getTip(){ return tip; }
}
