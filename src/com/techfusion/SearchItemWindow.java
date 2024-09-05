package com.techfusion;

import javax.swing.*;
import java.awt.*;

public class SearchItemWindow extends JFrame {

    public SearchItemWindow() {
        setTitle("Search Items");
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

        // Search field and button
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JTextField searchField = new JTextField(20);
        searchPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // Table for displaying search results
        String[] columnNames = {"#", "Name", "Item ID", "Category", "Quantity", "Supplier"};
        Object[][] data = {};  // Initially empty

        JTable searchTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(searchTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
