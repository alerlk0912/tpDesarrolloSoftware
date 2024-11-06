/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franco
 */
public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() { }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_datos", "usuario", "contraseña");
        }
        return connection;
    }
}
