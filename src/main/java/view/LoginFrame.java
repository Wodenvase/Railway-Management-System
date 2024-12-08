```java
package view;

import javax.swing.*;
import java.awt.*;
import controller.UserController;
import util.DatabaseInitializer;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private UserController userController;

    public LoginFrame() {
        userController = new UserController();
        initializeComponents();
        setupLayout();
        addListeners();
    }

    private void initializeComponents() {
        setTitle("Railway Management System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components with proper constraints
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        gbc.gridy = 3;
        add(registerButton, gbc);
    }

    private void addListeners() {
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            if (userController.validateLogin(username, password)) {
                new MainDashboard(username).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Invalid credentials", 
                    "Login Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            // Open registration form
            // Implementation for registration
        });
    }

    public static void main(String[] args) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            // Initialize database
            DatabaseInitializer.initializeDatabase();
            
            // Start application
            new LoginFrame().setVisible(true);
        });
    }
}
```