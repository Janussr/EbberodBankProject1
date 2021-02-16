package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * CREATED BY Janus @ 2021-02-16 - 16:01
 **/
public class Database {




    private Connection connection;
    private final String USER;
    private final String PASS;
    private final String URL;

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

}
