```java
package util;

import dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try {
            // Read SQL file
            String sql = new BufferedReader(
                new InputStreamReader(
                    DatabaseInitializer.class.getResourceAsStream("/database.sql")))
                .lines()
                .collect(Collectors.joining("\n"));

            // Execute SQL statements
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            
            for (String statement : sql.split(";")) {
                if (!statement.trim().isEmpty()) {
                    stmt.execute(statement);
                }
            }
            
            System.out.println("Database initialized successfully!");
        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```