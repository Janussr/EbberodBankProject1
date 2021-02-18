package ui;

import domain.Customer;
import domain.Transaction;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import persistence.Database;
import persistence.DbMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class MainController {
    //user & pass, from your local db
    private final String USER = "root";
    private final String PASS = "root1234";
    private final String URL = "jdbc:mysql://localhost:3306/ebberod_bank?serverTimezone=CET&useSSL=false";


    private Database database = new Database(USER, PASS, URL);
    private DbMapper dbMapper = new DbMapper(database);

    private List<Transaction> transactions;
    private Customer customer;

    Scanner sc = new Scanner(System.in);

    public void runProgram() throws InsufficientFundsException, InvalidAmountException, SQLException {

        printMainMenu();

        int choice = 0;
        while (choice != 9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawBalance();
                    break;
                case 3:
                    depositBalance();
                    break;
                case 4:
                    //Shows a list of the current database.
                    showCustomers();
                    break;
                case 5:
                    //Sets the balance of the account.
                    setBalance();
                    break;
                case 6:
                    break;
                case 7:
                    //Can withdraw or deposit in on method. Type true or false after the id and amount to be changed.
                    changeBalance();
                    break;
                case 9:
                    //:Todo keep the program running after it prints the menu. (Currently i closes)
                    printMainMenu();
                    break;
                case 0:
                    //self explanatory
                    exit();
                    break;
                default:
                    //   exit();
            }
        }
    }

    //case 0
    public void exit() {
        System.out.println("Exiting program...");
        System.exit(0);
    }

    //case 1 TODO: Id nummeret skal være baseret på scanner input
    private void checkBalance() throws SQLException {
        System.out.println("Enter your unique ID to view your balance: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        dbMapper.getkredit(IDnum);
    }

    //case 2
    private void withdrawBalance() throws SQLException {
        System.out.println("Enter your account ID: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        System.out.println("enter the amount you want to withdraw: ");
        int withdrawNum = sc.nextInt();
        dbMapper.withdrawBalance(IDnum, withdrawNum);
        }

    //case 3
    private void depositBalance() throws SQLException {
        System.out.println("Enter your account ID: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        System.out.println("enter the amount you want to deposit: ");
        int depositNum = sc.nextInt();
        dbMapper.depositBalance(IDnum, depositNum);
    }

    //case 4 -Show current customers in DB
    private void showCustomers() {
        List<Customer> allCustomers = dbMapper.getAllCustomers();
        for (Customer customer : allCustomers) {
            System.out.println(customer.toString());
        }
    }


    //case 7
    private void setBalance() throws SQLException {
        System.out.println("Type id number and amount of the account you want to set the balance of");
        dbMapper.updateDeposit(1, 100);
    }

    //Change balance either deposit or withdraw. first type in ur ID, then the amount to deposit or draw, then type true or false.
    private void changeBalance() {
        System.out.println("Enter your unique ID to view your balance: ");
        int IDnum = 0;
        IDnum = sc.nextInt();
        int depositNum = sc.nextInt();
        boolean t = sc.nextBoolean();
        dbMapper.changeBalance(IDnum, depositNum, t);
    }

    private void printMainMenu() throws InsufficientFundsException, SQLException, InvalidAmountException {
        System.out.println("1) View your balance.");
        System.out.println("2) Withdraw money from your account.");
        System.out.println("3) Deposit money to your account.");
        System.out.println("4) Show customers.");
        System.out.println("5) Set balance in ur account.");
        System.out.println("6) placeholder.");
        System.out.println("7) Change balance.");
        System.out.println("9) Print menu");
        System.out.println("0) Exit.");
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
