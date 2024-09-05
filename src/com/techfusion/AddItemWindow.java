package com.techfusion;

import javax.swing.*;
import java.awt.*;

public class AddItemWindow extends JFrame {

    public AddItemWindow() {
        setTitle("Add New Item to Canteen");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout
        setLayout(new BorderLayout(20, 20)); // Add padding around the edges

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 18);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

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
 
        // Left panel for the first three input fields
        JPanel leftPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        
        // Item Name
        JPanel itemNamePanel = new JPanel(new BorderLayout(5, 5));
        JLabel itemNameLabel = new JLabel("Item name: ");
        itemNameLabel.setFont(labelFont);
        JTextField itemNameField = new JTextField();
        itemNameField.setFont(fieldFont);
        itemNamePanel.add(itemNameLabel, BorderLayout.WEST);
        itemNamePanel.add(itemNameField, BorderLayout.CENTER);
        leftPanel.add(itemNamePanel);

        // Item ID
        JPanel itemIDPanel = new JPanel(new BorderLayout(5, 5));
        JLabel itemIDLabel = new JLabel("Item ID: ");
        itemIDLabel.setFont(labelFont);
        JTextField itemIDField = new JTextField();
        itemIDField.setFont(fieldFont);
        itemIDPanel.add(itemIDLabel, BorderLayout.WEST);
        itemIDPanel.add(itemIDField, BorderLayout.CENTER);
        leftPanel.add(itemIDPanel);

        // Item Category
        JPanel itemCategoryPanel = new JPanel(new BorderLayout(5, 5));
        JLabel itemCategoryLabel = new JLabel("Item Category: ");
        itemCategoryLabel.setFont(labelFont);
        JTextField itemCategoryField = new JTextField();
        itemCategoryField.setFont(fieldFont);
        itemCategoryPanel.add(itemCategoryLabel, BorderLayout.WEST);
        itemCategoryPanel.add(itemCategoryField, BorderLayout.CENTER);
        leftPanel.add(itemCategoryPanel);

        // Right panel for the next three input fields
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        
        // Supplier
        JPanel supplierPanel = new JPanel(new BorderLayout(5, 5));
        JLabel supplierLabel = new JLabel("Supplier: ");
        supplierLabel.setFont(labelFont);
        JTextField supplierField = new JTextField();
        supplierField.setFont(fieldFont);
        supplierPanel.add(supplierLabel, BorderLayout.WEST);
        supplierPanel.add(supplierField, BorderLayout.CENTER);
        rightPanel.add(supplierPanel);

        // Item Quantity
        JPanel itemQuantityPanel = new JPanel(new BorderLayout(5, 5));
        JLabel itemQuantityLabel = new JLabel("Item Quantity: ");
        itemQuantityLabel.setFont(labelFont);
        JTextField itemQuantityField = new JTextField();
        itemQuantityField.setFont(fieldFont);
        itemQuantityPanel.add(itemQuantityLabel, BorderLayout.WEST);
        itemQuantityPanel.add(itemQuantityField, BorderLayout.CENTER);
        rightPanel.add(itemQuantityPanel);

        // Price
        JPanel pricePanel = new JPanel(new BorderLayout(5, 5));
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setFont(labelFont);
        JTextField priceField = new JTextField();
        priceField.setFont(fieldFont);
        pricePanel.add(priceLabel, BorderLayout.WEST);
        pricePanel.add(priceField, BorderLayout.CENTER);
        rightPanel.add(pricePanel);

        // Add left and right panels to the main layout
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 20, 0)); // Add space between left and right panels
        inputPanel.add(leftPanel);
        inputPanel.add(rightPanel);
        add(inputPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton saveButton = new JButton("Save");
        saveButton.setFont(labelFont);
        buttonPanel.add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(labelFont);
        cancelButton.addActionListener(e -> {
            itemNameField.setText("");
            itemIDField.setText("");
            itemCategoryField.setText("");
            supplierField.setText("");
            itemQuantityField.setText("");
            priceField.setText("");
        });
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddItemWindow();
    }
}
