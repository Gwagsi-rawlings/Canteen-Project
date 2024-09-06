package com.techfusion;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class AddItemWindow extends JFrame {

    private JTextField itemNameField;
    private JTextField itemIDField;
    private JTextField categoryField;
    private JTextField quantityField;
    private JTextField supplierField;

    public AddItemWindow() {
        setTitle("Add New Item");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menu items
        JMenuItem homeMenu = new JMenuItem("Home");
        homeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Professional font for the menu

        JMenuItem addItemMenu = new JMenuItem("Add Item");
        addItemMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Professional font for menu items
        JMenuItem searchItemMenu = new JMenuItem("Search Item");
        searchItemMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Professional font for menu items

        // Add action listeners for the menu items
        homeMenu.addActionListener(e -> {
            dispose();
            new HomeWindow().setVisible(true);
        });
        addItemMenu.addActionListener(e -> {
            dispose();
            new AddItemWindow().setVisible(true);
        });
        searchItemMenu.addActionListener(e -> {
            dispose();
            new SearchItemWindow().setVisible(true);
        });

        // Add items to the menu bar
        menuBar.add(homeMenu);
        menuBar.add(addItemMenu);
        menuBar.add(searchItemMenu);

        // Set the menu bar
        setJMenuBar(menuBar);

        // Top panel with title and logo
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Add New Item to Canteen", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Add logo (Replace "logo.png" with your actual image path)
        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        topPanel.add(logoLabel, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);

        // Form fields for item input
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));

        // Input fields
        JLabel itemNameLabel = new JLabel("Item Name:");
        itemNameField = new JTextField(20);
        formPanel.add(itemNameLabel);
        formPanel.add(itemNameField);

        JLabel itemIDLabel = new JLabel("Item ID:");
        itemIDField = new JTextField(20);
        formPanel.add(itemIDLabel);
        formPanel.add(itemIDField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(20);
        formPanel.add(categoryLabel);
        formPanel.add(categoryField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(20);
        formPanel.add(quantityLabel);
        formPanel.add(quantityField);

        JLabel supplierLabel = new JLabel("Supplier:");
        supplierField = new JTextField(20);
        formPanel.add(supplierLabel);
        formPanel.add(supplierField);

        add(formPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton addItemButton = new JButton("Add Item");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(addItemButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action listener for "Add Item" button
        addItemButton.addActionListener(e -> addItemToDatabase());

        // Action listener for "Cancel" button (clears text fields)
        cancelButton.addActionListener(e -> clearForm());

        setVisible(true);
    }

    // Method to add item to the database
    private void addItemToDatabase() {
        String itemName = itemNameField.getText();
        String itemID = itemIDField.getText();
        String category = categoryField.getText();
        String quantity = quantityField.getText();
        String supplier = supplierField.getText();

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/canteen_inventory";  // Database URL
        String user = "youruser";  // Replace with your MySQL username
        String password = "yourpassword";  // Replace with your MySQL password

        // SQL query to insert item data
        String query = "INSERT INTO items (name, item_id, category, quantity, supplier) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the values from text fields into the SQL query
            preparedStatement.setString(1, itemName);
            preparedStatement.setString(2, itemID);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, Integer.parseInt(quantity));
            preparedStatement.setString(5, supplier);

            // Execute the update
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Item added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding item to the database.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
        }
    }

    // Method to clear form fields
    private void clearForm() {
        itemNameField.setText("");
        itemIDField.setText("");
        categoryField.setText("");
        quantityField.setText("");
        supplierField.setText("");
    }

    public static void main(String[] args) {
        new AddItemWindow();
    }
}
