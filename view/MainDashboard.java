```java
package view;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {
    private JTabbedPane tabbedPane;
    private SearchTrainsPanel searchTrainsPanel;
    private BookingPanel bookingPanel;
    private ReservationHistoryPanel historyPanel;
    private String username;

    public MainDashboard(String username) {
        this.username = username;
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Railway Management System - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        searchTrainsPanel = new SearchTrainsPanel();
        bookingPanel = new BookingPanel(username);
        historyPanel = new ReservationHistoryPanel(username);
    }

    private void setupLayout() {
        tabbedPane.addTab("Search Trains", searchTrainsPanel);
        tabbedPane.addTab("Book Tickets", bookingPanel);
        tabbedPane.addTab("Booking History", historyPanel);

        add(tabbedPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User");
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(e -> logout());
        userMenu.add(logoutItem);
        menuBar.add(userMenu);
        setJMenuBar(menuBar);
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to logout?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            new LoginFrame().setVisible(true);
            dispose();
        }
    }
}
```