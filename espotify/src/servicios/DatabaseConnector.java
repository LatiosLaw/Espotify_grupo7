/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author Nico
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/espotify"; // Cambia por tu nombre de base de datos
    private static final String USER = "root"; // Cambia por tu usuario
    private static final String PASSWORD = ""; // Cambia por tu contraseña

    public static Connection getConnection() {
    Connection conn = null;
    try {
        // Cargar el driver manualmente
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexion exitosa.");
    } catch (ClassNotFoundException e) {
        System.err.println("Driver no encontrado: " + e.getMessage());
    } catch (SQLException e) {
        System.err.println("Error de conexion: " + e.getMessage());
    }
    return conn;
}
}