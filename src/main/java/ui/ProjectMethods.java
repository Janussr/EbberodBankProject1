package ui;

import domain.Customer;
import persistence.Database;
import persistence.DbMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * CREATED BY Janus @ 2021-02-18 - 09:57
 **/
public class ProjectMethods {

    //user & pass, from your local db
    private final String USER = "root";
    private final String PASS = "root1234";
    private final String URL = "jdbc:mysql://localhost:3306/ebberod_bank?serverTimezone=CET&useSSL=false";


    private Database database = new Database(USER, PASS, URL);
    private DbMapper dbMapper = new DbMapper(database);

    Scanner sc = new Scanner(System.in);

    //case 0
    public void exit() {
        System.out.println("Exiting program...");
        System.exit(0);
    }

    //case 1
    public void checkBalance() throws SQLException {
        System.out.println("Enter your unique ID to view your balance: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        dbMapper.getkredit(IDnum);
        System.out.println("\n");
    }

    //case 2
    public void withdrawBalance() throws SQLException {
        System.out.println("Enter your account ID: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        System.out.println("enter the amount you want to withdraw: ");
        int withdrawNum = sc.nextInt();
        dbMapper.withdrawBalance(IDnum, withdrawNum);
        System.out.println("you succesfully withdrew: " + withdrawNum + "kr \n");

    }

    //case 3
    public void depositBalance() throws SQLException {
        System.out.println("Enter your account ID: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        System.out.println("enter the amount you want to deposit: ");
        int depositNum = sc.nextInt();
        dbMapper.depositBalance(IDnum, depositNum);
        System.out.println("you succesfully deposited: " + depositNum + "kr \n");
    }

    //case 4 -Show current customers in DB
    public void showCustomers() {
        List<Customer> allCustomers = dbMapper.getAllCustomers();
        for (Customer customer : allCustomers) {
            System.out.println(customer.toString());
        }
    }

    //case 7
    public void setBalance() throws SQLException {
        System.out.println("Your balance has been reset to 100kr\n");
        dbMapper.updateDeposit(1, 100);
    }

    //Change balance either deposit or withdraw. first type in ur ID, then the amount to deposit or draw, then type true or false.
    public void changeBalance() {
        System.out.println("Enter your unique ID to view your balance: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        System.out.println("Type the amount you want to withdraw or deposit: ");
        int depositNum = sc.nextInt();
        System.out.println("Type [true] to deposit and [false] to withdraw:");
        boolean t = sc.nextBoolean();
        dbMapper.changeBalance(IDnum, depositNum, t);
    }
}
