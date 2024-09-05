package com.techfusion;

import javax.swing.*;
import java.awt.*;

public class HomeWindow extends JFrame {

    public HomeWindow() {
        setTitle("ICT Canteen Inventory Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout
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

        // Top panel with logo
        JPanel topPanel = new JPanel(new BorderLayout());

        // Load and set the logo image
        ImageIcon logoIcon = new ImageIcon("logo.jpeg"); // Ensure the file path is correct
        JLabel logoLabel = new JLabel(logoIcon, JLabel.CENTER);
        topPanel.add(logoLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Center panel with welcome message
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JLabel welcomeLabel = new JLabel("Welcome to ICTU Canteen", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 24));  // Professional and bold font for emphasis
        centerPanel.add(welcomeLabel);

        JLabel subLabel = new JLabel("Inventory Management System", JLabel.CENTER);
        subLabel.setFont(new Font("Verdana", Font.ITALIC, 18));  // Italicized professional font
        centerPanel.add(subLabel);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with buttons and copyright
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        JButton addItemButton = new JButton("Add Item");
        addItemButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));  // Larger font for buttons
        addItemButton.setPreferredSize(new Dimension(150, 40));  // Set a consistent button size
        buttonPanel.add(addItemButton);

        JButton searchItemButton = new JButton("Search Item");
        searchItemButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));  // Larger font for buttons
        searchItemButton.setPreferredSize(new Dimension(150, 40));  // Set a consistent button size
        buttonPanel.add(searchItemButton);

        // Action listeners for the buttons to open respective windows
        addItemButton.addActionListener(e -> {
            dispose();
            new AddItemWindow().setVisible(true);
        });
        searchItemButton.addActionListener(e -> {
            dispose();
            new SearchItemWindow().setVisible(true);
        });

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Copyright label
        JLabel copyrightLabel = new JLabel("\u00A9 ICT University 2024", JLabel.CENTER);
        copyrightLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));  // Smaller, professional font for copyright
        bottomPanel.add(copyrightLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomeWindow();
    }
}
