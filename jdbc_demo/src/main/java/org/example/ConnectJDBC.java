package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private static String host = "localhost:1433";
    private static String username = "sa";
    private static String password = "24121999";
    private static String database = "AdventureWorksDW2022";
    private static String connectionURL = "jdbc:sqlserver://" + host + ";databaseName=" + database + ";user=" + username + ";password=" + password + ";encrypt=false";

    public static Connection connect(){
        try {
            return DriverManager.getConnection(connectionURL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
