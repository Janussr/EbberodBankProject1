package ui;

import domain.Customer;
import persistence.Database;
import persistence.DbMapper;

import java.sql.SQLException;
import java.util.List;

/**
 * CREATED BY Janus @ 2021-02-25 - 17:14
 **/
public class Customers {
    //user & pass, from your local db
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/ebberod_bank?serverTimezone=CET&useSSL=false";

    private static Database database = new Database(USER, PASS, URL);
    private static DbMapper dbMapper = new DbMapper(database);

    //case 4 -Show current customers in DB
    public static void showCustomers() {
        List<Customer> allCustomers = dbMapper.getAllCustomers();
        for (Customer customer : allCustomers) {
            System.out.println(customer.toString());
        }
    }

    //case 6 -Create user
    public static void createCustomer(String _name, String _city) throws SQLException {
        System.out.println("Creating customer");
        Customer custom = new Customer( _name, _city);
        dbMapper.createUser(custom);
    }

}
