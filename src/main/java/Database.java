import java.sql.*;

public class Database {
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/ebberodbank?serverTimezone=CET&useSSL=false";
    private static Connection connection;

    public static void main(String[] args) {
        System.out.println("JDBC DEMO");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fejl ved instantiering af Driver klasse");
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Fejl under etablering af forbindelse til DB");
        }

        String sql = "select * from kunder";

        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idcustomer = rs.getInt("idkunder");
                String name = rs.getString("navn");
                String city = rs.getString("by");


                System.out.println("kunde nr " + idcustomer);
                System.out.println("kunde navn " + name);
                System.out.println("kunde by " + city);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}