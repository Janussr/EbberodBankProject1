package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * CREATED BY Janus @ 2021-02-16 - 16:01
 **/
public class Database {

    //user & pass, from your local db

    private Connection connection;


    private String USER = "root";
    private String PASS = "root";
    private String URL = "jdbc:mysql://localhost:3306/ebberod_bank?serverTimezone=CET&useSSL=false";

    public Database(String user, String pass, String url) {
        this.connection = connection;
        USER = user;
        PASS = pass;
        URL = url;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fejl ved instantiering af Driver klasse");
        }


    }
    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Fejl under etablering af forbindelse til DB");
        }
        return connection;
    }
    public void closeConnection() throws SQLException{
        DriverManager.getConnection(URL, USER, PASS).close();
    }
}
