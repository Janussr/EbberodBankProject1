import java.util.List;
import java.util.Scanner;
import java.sql.*;
import java.util.Date;


public class MainController {

    private List<Transaction> transactions;
    private Customer customer;

    Scanner sc = new Scanner(System.in);
    public void runProgram() {

        printMainMenu();

       int choice = 0;
       while (choice != 9) {
           choice = sc.nextInt();
           switch (choice) {
               case 1:
                   getBalance();
                   break;
               case 2:
                   withDrawAmount();
                   break;
               case 3:
                   depositAmount();
                   break;
               /*case 4:
                   placeHolder();
                   break;
               case 5:
                   placeHolder();
                   break;
               case 6:
                   placeHolder();
                   break;*/
               case 0:
                   exit();
                   break;
               default:
                   exit();
           }
       }
    }

    //Functions to the related switch-case number will be added below here.

    //case 0
    public void exit() {
        System.out.println("Exiting program...");
    }

    //case 1
    public int getBalance(){
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }
        return sum;
    }

    //case 2
    public int withDrawAmount(int amount) throws InsufficientFundsException{
        if(amount <= getBalance()) {
            transactions.add(new Transaction(-amount, new Date()));
        } else {
            throw new InsufficientFundsException();
        }
        return getBalance();
    }

    //case 3
    public int depositAmount(int amount) throws InvalidAmountException{
        if(amount > 0) {
            transactions.add(new Transaction(amount, new Date()));
        } else {
            throw new InvalidAmountException();
        }
        return getBalance();
    }

    private void printMainMenu() {
        System.out.println("1) PlaceHolder.");
        System.out.println("2) PlaceHolder.");
        System.out.println("3) PlaceHolder.");
        System.out.println("4) PlaceHolder.");
        System.out.println("5) PlaceHolder.");
        System.out.println("6) PlaceHolder.");
        System.out.println("0) Exit.");
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
