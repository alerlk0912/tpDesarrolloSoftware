package Tp.DS.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SINGLETON
public class DatabaseConnection {
    private static Connection connection;
    private static String usuario;
    private static String password;

 
   private DatabaseConnection( ) {
        
   }
   public static void setCredentials(String usuarioIngresado, String passwordIngresado) {
        usuario = usuarioIngresado;
        password = passwordIngresado;
    }
   

    public static Connection getInstance() throws SQLException {
        if (!"root".equals(usuario) || !"AmD6Kk3ASlaLdQsa1".equals(password)) {
            throw new SQLException("Usuario o contraseña incorrectos.");
        }
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpds", usuario, password);
        }
        return connection;
    }
}
