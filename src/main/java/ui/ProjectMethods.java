package ui;

import domain.Customer;
import persistence.Database;
import persistence.DbMapper;
import persistence.DbMapperI;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * CREATED BY Janus @ 2021-02-18 - 09:57
 **/
public class ProjectMethods {

    //user & pass, from your local db
    private final String USER = "root";
    private final String PASS = "root";
    private final String URL = "jdbc:mysql://localhost:3306/ebberod_bank?serverTimezone=CET&useSSL=false";

    private Database database = new Database(USER, PASS, URL);
    private DbMapper dbMapper = new DbMapper(database);

  // private DbMapperI dbMapperI;

  // public ProjectMethods(DbMapper dbMapper) {
  //     this.dbMapper = dbMapper;
  // }


    //case 0
    public void exit() {
        System.out.println("Exiting program...");
        System.exit(0);
    }

}
