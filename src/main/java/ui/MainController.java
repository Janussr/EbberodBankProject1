package ui;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import persistence.Database;
import persistence.DbMapper;
import persistence.DbMapperI;

import java.sql.SQLException;
import java.util.Scanner;


public class MainController {


  // private Database database = new Database("USER","PASS","URL");
  // private DbMapperI dbmapi = new DbMapper(database);
  // private ProjectMethods accmethod = new ProjectMethods();

    ProjectMethods accmethod = new ProjectMethods();

    Scanner sc = new Scanner(System.in);

    public void runProgram() throws InsufficientFundsException, InvalidAmountException, SQLException {

        printMainMenu();

        int choice = 0;
        while (choice != 9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BankAccount.checkBalance();
                    printMainMenu();
                    break;
                case 2:
                    BankAccount.withdrawBalance();
                    printMainMenu();
                    break;
                case 3:
                    BankAccount.depositBalance();
                    printMainMenu();
                    break;
                case 4:
                    //Shows a list of the current database.
                    Customers.showCustomers();
                    printMainMenu();
                    break;
                case 5:
                    //Sets the balance of the account.
                    BankAccount.setBalance();
                    printMainMenu();
                    break;
                case 6:
                    //Create user
                    String name = sc.next();
                    String city = sc.next();
                    Customers.createCustomer(name,city);
                    printMainMenu();
                    break;
                case 8:
                    //Can withdraw or deposit in on method. Type true or false after the id and amount to be changed.
                    BankAccount.changeBalance();
                    printMainMenu();
                    break;
                case 9:
                    //:Todo keep the program running after it prints the menu. (Currently it closes)
                    printMainMenu();
                    break;
                case 0:
                    accmethod.exit();
                    break;
                default:
            }
        }
    }

    private void printMainMenu() throws InsufficientFundsException, SQLException, InvalidAmountException {
        System.out.println("1) View your balance.");
        System.out.println("2) Withdraw money from your account.");
        System.out.println("3) Deposit money to your account.");
        System.out.println("4) Show customers.");
        System.out.println("5) Reset database balance.");
        System.out.println("6) Create user.");
        System.out.println("8) Change balance.");
        System.out.println("9) Print menu");
        System.out.println("0) Exit.");
    }
}
