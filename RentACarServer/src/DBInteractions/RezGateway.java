package DBInteractions;

import Logic.Masina;
import Logic.Rezervare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Devene on 5/18/2016.
 */
public class RezGateway {
    private Connection con;
    private Statement st;
    private ResultSet rez;

    private void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/masini","root","");
        }catch (Exception ex) {
            System.out.println("Errot: " + ex);
        }
    }
    public void rezerva(Rezervare rez){
        try{
            CarGateway gateM = new CarGateway();
            gateM.update(rez.getMas(),"rezervat");
            String[] val = rez.getCont().split(",");
            Masina mas = rez.getMas();
            Connect();
            st = con.createStatement();
            int res = st.executeUpdate("insert into masini.rezervari value(default,\'"+val[0]+"\',\'"+val[1]+"\',\'"+mas.getProducator()+"\',\'"+mas.getModel()+"\',\'"+rez.getDataB()+"\',\'"+rez.getDataE()+"\',\'"+rez.getTimp()+"\',\'neprocesat\')");
            closeCon();
        }catch(Exception ex){

        }
    }
    public String findRez() {
        Connect();
        try {
            String lista = "";
            st = con.createStatement();
            rez = st.executeQuery("select * from masini.rezervari where procesat=\'neprocesat\'");
            while (rez.next()) {
                String nume = rez.getString("nume");
                String email = rez.getString("email");
                String prod = rez.getString("producator");
                String model = rez.getString("model");
                String dataB = rez.getString("dataB");
                String dataE = rez.getString("dataE");
                String timp = rez.getString("logat");
                String cont = nume + "," + email;
                lista+=cont+","+prod+","+model+","+dataB+","+dataE+","+timp+";";
            }
            closeCon();
            return lista;
        } catch (Exception ex) {
            return "";
        }
    }
    public void closeCon() {
        try {
            if (rez != null) {
                rez.close();
            }

            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }
}
