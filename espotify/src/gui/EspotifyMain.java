/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui;

/**
 *
 * @author Law
 */
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import servicios.DatabaseConnector;

public class EspotifyMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Espotify");
        frame.setSize(200, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar el driver JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
            return; // Salir si no se puede cargar el driver
        }

        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                System.out.println("Conexion establecida.");

                // Inserción de datos
                String sql = "INSERT INTO usuarios (user, pass) VALUES (?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, "admin");
                    pstmt.setString(2, "admin");
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Insercion exitosa.");
                    } else {
                        System.out.println("No se insertaron filas.");
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexion.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
    }
}
