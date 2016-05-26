package DBInteractions;

import Logic.User;

import java.sql.*;
import java.util.Random;

/**
 * Created by Devene on 3/23/2016.
 */
public class UserGateway {
    private Connection con;
    private Statement st;
    private ResultSet rez;
    private PreparedStatement pst;

    public void update(User user){
        Connect();
        try{
            st = con.createStatement();
            int res = st.executeUpdate("update users set email=\'"+user.getEmail()+"\' ,parola=\'"+user.getParola()+"\' where nume=\'"+user.getNume()+"\'");
        }catch (Exception ex) {

        }
    }
    public User acces(String nume,String parola){
        Connect();
        try {
            st = con.createStatement();
            rez = st.executeQuery("select * from masini.users where nume=\'"+nume+"\' and parola=\'"+parola+"\'");
            if(rez.next()) {
                String numeU = rez.getString("nume");
                String pass = rez.getString("parola");
                String email = rez.getString("email");
                String tip = rez.getString("tip");
                User cont = new User(numeU,pass,email,tip);
                closeCon();
                return cont;
            }
            closeCon();
            return null;
        }catch (Exception e) {
            closeCon();
            return null;
        }
    }
    public void insert(User cont){
        try{
            User ver = find(cont.getNume());
            Connect();
            st = con.createStatement();
            if(ver==null) {
                int res = st.executeUpdate("insert into masini.users values (default,\'" + cont.getNume() + "\',\'" + cont.getParola() + "\',\'" + cont.getEmail() + "\',\'" + cont.getTip() + "\')");
                closeCon();
            }
            closeCon();
        }catch (Exception ex) {
            closeCon();
        }
    }
    private void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/masini","root","");
        }catch (Exception ex) {
            System.out.println("Errot: " + ex);
        }
    }
    public User find(String owner){
        Connect();
        try {
            st = con.createStatement();
            rez = st.executeQuery("select * from masini.users where nume=\'"+owner+"\'");
            if(rez.next()) {
                String nume = rez.getString("nume");
                String pass = rez.getString("parola");
                String email = rez.getString("email");
                String tip = rez.getString("tip");
                User cont = new User(nume,pass,email,tip);
                closeCon();
                return cont;
            }
            closeCon();
            return null;
        }catch (Exception e) {
            closeCon();
            return null;
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
