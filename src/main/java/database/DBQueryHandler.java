package database;

import components.Task;
import database.model.BusinessAcc;
import database.model.PersonalAcc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBQueryHandler {

    Connection connection;
    PreparedStatement preparedStatement;
    int task_index;
    int user_index;
    public DBQueryHandler(){

        connection=DBConnection.getConnection();
        task_index=0;
        user_index=0;
    }

    public void saveTask(Task task) throws SQLException {
        preparedStatement=connection.prepareStatement("INSERT INTO tasks (id, userid, companyid, title, description, duedate, status) VALUES(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, task_index++);
        preparedStatement.setInt(2, task.getUserID());
        preparedStatement.setInt(3, task.getCompanyID());
        preparedStatement.setString(4, task.getTITLE());
        preparedStatement.setString(5, task.getDESCRIPTION());
        preparedStatement.setDate(6, Date.valueOf(task.getDueDATE()));
        preparedStatement.setInt(7, task.getStatus());
        preparedStatement.executeUpdate();
    }

    public void saveUser(PersonalAcc user) throws SQLException{
        preparedStatement=connection.prepareStatement("INSERT INTO users (id, companyid, username, upassword) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, user_index++);
        user.setId(user_index);
        if(user instanceof BusinessAcc)preparedStatement.setInt(2, ((BusinessAcc)user).getComp_ID());
        else preparedStatement.setInt(2, -1);
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();
    }

    public PersonalAcc isUser(String username) throws SQLException {
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery("SELECT username, password, companyid FROM users where username=\'"+username+"\'");

        String userName=r.getString("username");
        String password=r.getString("password");
        int compId=r.getInt("companyid");

        PersonalAcc acc;

        if(userName.isEmpty()) return null;
        else {
            if(compId==-1) {
                acc = new PersonalAcc(userName);
            }
            else acc=new BusinessAcc(userName, compId);
            acc.setPassword(password);
            return acc;
        }
    }

    public List<Task> selectTasks() throws SQLException {
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery("SELECT id, userid, companyid, title, description, duedate, status FROM tasks");

        ArrayList<Task> tasks=new ArrayList<>();
        while(r.next()){
            int id=r.getInt("id");
            int userId= r.getInt("userid");
            int companyId= r.getInt("companyid");
            String title=r.getString("title");
            String description=r.getString("description");
            Date dueDate=r.getDate("duedate");
            String status=r.getString("status");

            tasks.add(new Task(userId, companyId, title, description, dueDate.toLocalDate()));
        }
        return tasks;
    }
}
