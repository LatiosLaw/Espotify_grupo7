package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "tecnologo";
    private static final String PASSWORD = "tecnologo";

    public static void createDatabaseIfNotExists() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement()) {
            String sql = "CREATE DATABASE IF NOT EXISTS espotify";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}