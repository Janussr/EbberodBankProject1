package persistence;

import domain.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY Janus @ 2021-02-16 - 16:21
 **/
public class DbMapper implements DbMapperI {

    public DbMapper(Database database) {
        this.database = database;
    }

    private Database database;

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();

        String sql = "select * from customer";

        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                customerList.add(new Customer(id, name, city));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return customerList;
    }


    @Override
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

    @Override
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

    @Override
    public int withdrawBalance(int _id, int withdraw) {
        String sql;
        sql = "UPDATE account SET balance = balance - " + withdraw + " WHERE id =  " + _id;
        try (PreparedStatement ps = database.connect().prepareStatement(sql)) {
            //  ps.setString(1, String.valueOf(deposit));
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return _id;
    }

    @Override
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

    @Override
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

    public void createUser(Customer customer) throws SQLException {
        try {
            //Connection connect = database.connect();
            String SQL = "INSERT INTO customer (name, city) VALUES (?,?)";
            PreparedStatement ps = database.connect().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getCity());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            customer.setCustomer_id(id);
            database.closeConnection();

        } catch (SQLException e) {
            System.out.println("Lmao fail in creating new user");
        }
    }
}

