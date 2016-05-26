package Logic;


/**
 * Created by Devene on 5/17/2016.
 */
public class Querry {
    private String dataB;
    private String dataE;
    private String city;

    public Querry(String dataB,String dataE,String city){
        this.dataB = dataB;
        this.dataE = dataE;
        this.city = city;
    }
    public String getDataB(){return dataB;}
    public String getDataE(){return dataE;}
    public String getCity(){return city;}
}
