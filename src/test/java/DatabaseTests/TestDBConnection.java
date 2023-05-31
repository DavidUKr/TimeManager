package DatabaseTests;

import database.DBQueryHandler;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDBConnection {

    @Test
    @DisplayName("Test database connection")
    void TestConnectionCredentials() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/TimeManager";
        String user="timemanager";
        String password="tm1234";
        Connection con;
        assertNotNull(con=DriverManager.getConnection(url, user, password));
        System.out.println(con);
    }

    @Test
    @DisplayName("Test connection with implemented DB connector")
    void TestConnection() throws SQLException {

        assertNotNull(new DBQueryHandler());
    }
}
