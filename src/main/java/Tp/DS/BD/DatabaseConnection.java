package Tp.DS.BD;

import java.sql.Connection;
import java.sql.*;

// SINGLETON
public class DatabaseConnection {
    private static Connection connection;
    private static String usuario;
    private static String password;

   public DatabaseConnection( ) {
        
   }
   public static void setCredentials(String usuarioIngresado, String passwordIngresado) {
        usuario = usuarioIngresado;
        password = passwordIngresado;
    }

    public static Connection getInstance() throws SQLException {
        if (!"root".equals(usuario)) {
            throw new SQLException("Usuario o contraseña incorrectos.");
        }
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpds", usuario, password);
        }        
        return connection;
    }
}
