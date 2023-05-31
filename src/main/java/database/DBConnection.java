package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        String url="jdbc:postgresql://localhost:5432/TimeManager";
        String user="timemanager";
        String password="tm1234";

        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
