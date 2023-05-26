package database;

import components.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBQueryHandler {

    Connection connection;
    PreparedStatement preparedStatement;
    public DBQueryHandler(){
        connection=DBConnection.getConnection();
    }

    public void saveTask(Task task){
        preparedStatement=connection.prepareStatement("INSERT INTO TASKS")
    }
}
