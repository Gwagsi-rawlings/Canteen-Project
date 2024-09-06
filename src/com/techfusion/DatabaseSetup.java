package com.techfusion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/canteen";
        String user = "canteen_user";  // Replace with your MySQL username
        String password = "canteen123";  // Replace with your MySQL password

        // SQL statement to create the inventory table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS items ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(100) NOT NULL,"
                + "category VARCHAR(100),"
                + "supplier VARCHAR(100),"
                + "quantity INT,"
                + "price DECIMAL(10, 2)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Execute the create table SQL statement
            stmt.execute(createTableSQL);
            System.out.println("Table 'items' created successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
