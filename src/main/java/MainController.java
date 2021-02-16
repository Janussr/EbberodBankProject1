import java.util.Scanner;
import java.sql.*;


public class MainController {

    Scanner sc = new Scanner(System.in);
    public void runProgram() {

        printMainMenu();

       int choice = 0;
       while (choice != 9) {
           choice = sc.nextInt();
           switch (choice) {
               case 1:
                   //placeHolder();
                   break;
               case 2:
//                   break;
               case 3:
                //   placeHolder();
                   break;
               case 4:
                //   placeHolder();
                   break;
               case 5:
                //   placeHolder();
                   break;
               case 6:
                //   placeHolder();
                   break;
               case 0:
               //    exit();
                   break;
               default:
                //   exit();
           }
       }
    }

    //Functions to the related switch-case number will be added below here.



    private void printMainMenu() {
        System.out.println("1) PlaceHolder.");
        System.out.println("2) PlaceHolder.");
        System.out.println("3) PlaceHolder.");
        System.out.println("4) PlaceHolder.");
        System.out.println("5) PlaceHolder.");
        System.out.println("6) PlaceHolder.");
        System.out.println("0) Exit.");
    }
}
