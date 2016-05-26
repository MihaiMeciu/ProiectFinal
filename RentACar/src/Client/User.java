package Client;

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
    public User(String nume,String pass){
        this.nume = nume;
        this.parola = pass;
    }
    public String getNume(){return nume;}
    public String getParola(){return parola;}
    public String getEmail(){return email;}
    public String getTip(){return tip;}
}
