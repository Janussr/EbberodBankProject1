package ui;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

import java.sql.SQLException;
import java.util.Scanner;


public class MainController {
    private ProjectMethods accmethod = new ProjectMethods();


    Scanner sc = new Scanner(System.in);

    public void runProgram() throws InsufficientFundsException, InvalidAmountException, SQLException {

        printMainMenu();

        int choice = 0;
        while (choice != 9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    accmethod.checkBalance();
                    printMainMenu();
                    break;
                case 2:
                    accmethod.withdrawBalance();
                    printMainMenu();
                    break;
                case 3:
                    accmethod.depositBalance();
                    printMainMenu();
                    break;
                case 4:
                    //Shows a list of the current database.
                    accmethod.showCustomers();
                    printMainMenu();
                    break;
                case 5:
                    //Sets the balance of the account.
                    accmethod.setBalance();
                    printMainMenu();
                    break;
                case 6:
                    //Can withdraw or deposit in on method. Type true or false after the id and amount to be changed.
                    accmethod.changeBalance();
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
        System.out.println("6) Change balance.");
        System.out.println("9) Print menu");
        System.out.println("0) Exit.");
    }
}
