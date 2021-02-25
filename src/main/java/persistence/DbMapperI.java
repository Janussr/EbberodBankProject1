package persistence;

import domain.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * CREATED BY Janus @ 2021-02-19 - 11:16
 **/
public interface DbMapperI {

    List<Customer> getAllCustomers();

    int getkredit(int id) throws SQLException;

    int updateDeposit(int _id, int deposit) throws SQLException;

    int withdrawBalance(int _id, int withdraw);

    int depositBalance(int _id, int deposit);

    int changeBalance(int _id, int deposit, boolean _t);
}
