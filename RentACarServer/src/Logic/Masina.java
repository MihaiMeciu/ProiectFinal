package Logic;

import DBInteractions.CarGateway;

import java.util.ArrayList;

/**
 * Created by Devene on 5/17/2016.
 */
public class Masina {
    private String producator;
    private String model;
    private String anF;
    private String poza;
    private int rulaj;
    private String oras;
    private String status;

    public Masina(String producator,String model,String anF,String poza,int rulaj,String oras){
        this.producator = producator;
        this.model  = model;
        this.anF = anF;
        this.poza = poza;
        this.rulaj = rulaj;
        this.oras = oras;
    }
    public Masina(String producator,String model,String anF,String oras){
        this.producator = producator;
        this.model = model;
        this.anF = anF;
        this.oras = oras;
    }
    public Masina(String prod,String model,String anF,String poze,int rulaj,String oras,String status){
        this.producator = prod;
        this.model = model;
        this.anF = anF;
        this.poza = poze;
        this.rulaj = rulaj;
        this.oras = oras;
        this.status = status;
    }
    public Masina(String prod,String model,String anF,int rulaj,String oras,String status){
        this.producator = prod;
        this.model = model;
        this.anF = anF;
        this.rulaj = rulaj;
        this.oras = oras;
        this.status = status;
    }
    public String getData(){ return producator+" - "+model; }
    public String getProducator(){ return producator; }
    public String getModel(){ return model;}
    public String getAnF(){ return anF; }
    public String getPoza(){ return poza; }
    public int getRulaj(){ return rulaj; }
    public String getOras(){return oras;}
    public String getStatus(){return status;}
    public static void insert(String mas){
        CarGateway gate = new CarGateway();
        String[] date = mas.split(",");
        Masina nou = new Masina(date[0],date[1],date[2],Integer.parseInt(date[3]),date[4],"nerezervat");
        gate.insert(nou);
    }
    public static String findCars(String cauta){
        CarGateway gate = new CarGateway();
        String[] val = cauta.split(",");
        Querry c = new Querry(val[0],val[1],val[2]);
        return gate.findCars(c);
    }
    public static void update(String date){
        String[] val = date.split(",");
        Masina mas = new Masina(val[0],val[1],val[2],Integer.parseInt(val[3]),val[4],val[5]);
        CarGateway gate = new CarGateway();
        gate.update(mas,val[5]);
    }
    public static Masina find(String prod,String model,String anF){
        CarGateway gate = new CarGateway();
        return gate.find(prod,model,anF);
    }
}
