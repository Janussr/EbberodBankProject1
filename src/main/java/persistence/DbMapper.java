package persistence;

import domain.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY Janus @ 2021-02-16 - 16:21
 **/
public class DbMapper {

    public DbMapper(Database database) {
        this.database = database;
    }

    private Database database;

    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();

        String sql = "select * from customer";

        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                customerList.add(new Customer(customer_id, name, city));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return customerList;
    }

}
