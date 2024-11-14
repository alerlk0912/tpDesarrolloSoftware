package Tp.DS.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SINGLETON
public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() { 
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpds", "root", "AmD6Kk3ASlaLdQsa1");
        }
        return connection;
    }
}
