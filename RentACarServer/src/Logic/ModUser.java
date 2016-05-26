package Logic;

import DBInteractions.UserGateway;

/**
 * Created by Devene on 5/19/2016.
 */
public class ModUser {
    private String nume;

    public ModUser(String nume){
        this.nume = nume;
    }
    public String getNume(){return nume;}
    public User find(String nume){
        UserGateway gate = new UserGateway();
        return gate.find(nume);
    }
}
