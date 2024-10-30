package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
                                        //jdbc:postgresql://db:5432/espotify21
    private static final String DB_URL = "jdbc:postgresql://db:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "121212";

    public static void createDatabase() {
        boolean token = false;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement()) {
            String sql ;
           
            
            sql = "CREATE DATABASE espotify21";
            statement.executeUpdate(sql);

            
        } catch (SQLException e) {
           // e.printStackTrace();
            token = true;
        }
    }
}