package Logic;

import DBInteractions.CarGateway;

/**
 * Created by Devene on 5/19/2016.
 */
public class ModMasina {
    private String prod;
    private String model;
    private String anF;

    public ModMasina(String prod,String model,String anF){
        this.prod = prod;
        this.model = model;
        this.anF = anF;
    }
    public Masina find(String prod,String model,String anF){
        CarGateway gate = new CarGateway();
        return gate.find(prod,model,anF);
    }
    public String getProd(){return prod;}
    public String getModel(){return model;}
    public String getAnF(){return anF;}
}
