package DBInteractions;

import Logic.Masina;
import Logic.Querry;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Devene on 5/18/2016.
 */
public class CarGateway {

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
    public void update(Masina mas,String status){
        Connect();
        try{
            st = con.createStatement();
            int rez = st.executeUpdate("update masini set rezervat=\'"+status+"\',oras=\'"+mas.getOras()+"\', rulaj=\'"+Integer.toString(mas.getRulaj())+"\' where producator=\'"+mas.getProducator()+"\' and model=\'"+mas.getModel()+"\' and anF=\'"+mas.getAnF()+"\'");
            closeCon();
        }catch(Exception ex){

        }
    }
    public void insert(Masina mas){
        try{
            Masina ver = find(mas.getProducator(),mas.getModel(),mas.getAnF());
            Connect();
            st = con.createStatement();
            if(ver==null) {
                int res = st.executeUpdate("insert into masini.masini values (default,\'" + mas.getProducator() + "\',\'" + mas.getModel() + "\',\'" + mas.getAnF() + "\',\'" + mas.getPoza() + "\',\'"+Integer.toString(mas.getRulaj())+"\',\'"+mas.getOras()+"\',\'false\')");
                closeCon();
            }
            closeCon();
        }catch (Exception ex) {
            closeCon();
        }
    }
    public Masina find(String producator,String model,String anF){
        Connect();
        try{
            st = con.createStatement();
            rez = st.executeQuery("select * from masini.masini where producator=\'"+producator+"\' and model=\'"+model+"\' and anF=\'"+anF+"\'");
            if(rez.next()){
                String prod = rez.getString("producator");
                String mod = rez.getString("model");
                String an = rez.getString("anF");
                String poze = rez.getString("poze");
                int rulaj = rez.getInt("rulaj");
                String oras = rez.getString("oras");
                String status = rez.getString("rezervat");
                Masina mas = new Masina(prod,mod,an,poze,rulaj,oras,status);
                closeCon();
                return mas;
            }
            closeCon();
            return null;
        }catch(Exception ex){
            closeCon();
            return null;
        }
    }
    public String findCars(Querry cauta){
        Connect();
        try{
            String lista = "";
            st = con.createStatement();
            rez = st.executeQuery("select * from masini.masini where oras=\'"+cauta.getCity()+"\' and rezervat=\'nerezervat\'");
            while(rez.next()){
                String prod = rez.getString("producator");
                String mod = rez.getString("model");
                String an = rez.getString("anF");
                String poze = rez.getString("poze");
                int rulaj = rez.getInt("rulaj");
                String oras = rez.getString("oras");
                lista+=prod+","+mod+","+an+","+poze+","+Integer.toString(rulaj)+","+oras+";";
            }
            closeCon();
            return lista;
        }catch(Exception ex){
            closeCon();
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
