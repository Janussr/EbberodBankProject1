package persistence;

import domain.Customer;

import java.sql.Connection;
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
                int customer_id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                customerList.add(new Customer(customer_id, name, city));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return customerList;
    }


    public int getkredit(int id) throws SQLException {
        String sql = "select balance from account WHERE id = ?";

        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int balance = rs.getInt("balance");
                System.out.println(balance);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
        return id;
    }

    public int updateDeposit(int id) throws SQLException {
        String sql = "update users set num_points = 6000 where id = 2";
        String query = "update balance set account WHERE id = ?,?";
        try (PreparedStatement ps = database.connect().prepareStatement(query)) {
            ps.setInt(1, 1);
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
        return id;

    }
}

