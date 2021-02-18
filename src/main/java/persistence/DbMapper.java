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

    public int updateDeposit(int _id, int deposit) throws SQLException {
        String sql = "UPDATE  account SET balance = ? + 0 WHERE id =  " + _id;
        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            ps.setString(1, String.valueOf(deposit));
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();

            //String sql = "UPDATE  account SET balance = ? + 0 WHERE id = '1'";

        }
        return _id;

    }

    public int withdrawBalance(int _id, int deposit) {
        String sql;
        sql = "UPDATE account SET balance = balance - " + deposit + " WHERE id =  " + _id;
        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            //  ps.setString(1, String.valueOf(deposit));
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return _id;
    }

    public int depositBalance(int _id, int deposit) {
        String sql = "UPDATE  account SET balance = balance + " + deposit + " WHERE id =  " + _id;
        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            //  ps.setString(1, String.valueOf(deposit));
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return _id;
    }

    public int changeBalance(int _id, int deposit, boolean _t) {
        String sql;
        if (_t) {
            sql = "UPDATE  account SET balance = balance + " + deposit + " WHERE id =  " + _id;
        } else {
            sql = "UPDATE  account SET balance = balance - " + deposit + " WHERE id =  " + _id;
        }
        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            //  ps.setString(1, String.valueOf(deposit));
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return _id;

    }
}

