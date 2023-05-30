package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        String url="jdbc:postgresql://localhost:5432/TimeManager";
        String user="postgres";
        String password="pIcia056";

        try {
            connection= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Could not return connection");
        }

        return connection;
    }
}