package domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int account_id;

    private List<Transaction> transactions;
    private Customer customer;

    public Account(int account_id, Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
        this.account_id = account_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    //Hmm ... det ikke sikkert den overhovedet hører til her ... skal måske rykkes til controller.
    public List<Transaction> getTransactions() {
        return transactions;
    }
}