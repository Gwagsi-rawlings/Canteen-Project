package com.techfusion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/canteen_inventory";
        String username = "gwagsi.rawling@ictuniversity.edu.cm"; // or your DB username
        String password = "Nshom@ictu2022"; // or your DB password
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Optional with recent JDBC versions
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace();
        }
    }
}
