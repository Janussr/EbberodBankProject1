package ui;

import domain.Customer;
import domain.Transaction;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import persistence.Database;
import persistence.DbMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Date;


public class MainController {
    //user & pass, from your local db
    private final String USER = "root";
    private final String PASS = "root";
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
                    //withDrawAmount();
                    break;
                case 3:
                    //depositAmount();
                    break;
                case 4:
                    showCustomers();
                    break;
                case 5:
                    break;
                case 6:
                    updateBalance();
                    break;
                case 9:
                    printMainMenu();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    //   exit();
            }
        }
    }

    //Functions to the related switch-case number will be added below here.

    //case 9
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
    //TODO: der må ikke kunne overtrækkes.
   // public int withDrawAmount() throws InsufficientFundsException {
   //     int amount = 0;
   //     System.out.println("Enter your desired withdrawal: ");
   //     amount = sc.nextInt();
   //     if (amount <= getBalance()) {
   //         transactions.add(new Transaction(-amount, new Date()));
   //         System.out.println(String.format("Ny balance: %d", getBalance()));
   //     } else {
   //         throw new InsufficientFundsException();
   //     }
   //     return getBalance();
   // }

    //case 3
    //TODO: der må ikke kunne overtrækkes.
  //  public int depositAmount() throws InvalidAmountException {
  //      int amount = 0;
  //      System.out.println("Enter your desired deposit: ");
  //      amount = sc.nextInt();
  //      if (amount > 0) {
  //          transactions.add(new Transaction(amount, new Date()));
  //          System.out.println(String.format("Ny balance: %d", getBalance()));
  //      } else {
  //          throw new InvalidAmountException();
  //      }
  //      return getBalance();
  //  }

    //case 4 -Show current customers in DB
    private void showCustomers() {
        List<Customer> allCustomers = dbMapper.getAllCustomers();
        for (Customer customer : allCustomers) {
            System.out.println(customer.toString());
        }
    }




    //case 6
    private void updateBalance() throws SQLException {
        dbMapper.updateDeposit(1);
    }

    private void printMainMenu() throws InsufficientFundsException, SQLException, InvalidAmountException {
        System.out.println("1) View your balance.");
        System.out.println("2) Withdraw money from your account.");
        System.out.println("3) Deposit money to your account.");
        System.out.println("4) Show customers.");
        System.out.println("5) Check balance.");
        System.out.println("6) update.");
        System.out.println("9) Print menu");
        System.out.println("0) Exit.");
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
