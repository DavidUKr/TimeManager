package database;

import components.Task;
import database.model.BusinessAcc;
import database.model.PersonalAcc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBQueryHandler {

    Connection connection;
    PreparedStatement preparedStatement=null;
    int task_index;
    int user_index;
    int compId;
    public DBQueryHandler() throws SQLException {

        connection=DBConnection.getConnection();
        connection.setAutoCommit(true);
        task_index=100;
        user_index=100;
        compId=1;
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
        if(user instanceof BusinessAcc){
            compId=((BusinessAcc)user).getComp_ID();
            preparedStatement.setInt(2, compId);
        }
        else {
            compId=1;
            preparedStatement.setInt(2, compId);
        }
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassword());

        System.out.println("id:"+user_index+"; companyid:"+compId+"; username:"+user.getUserName()+"; password:"+user.getPassword());
        preparedStatement.executeUpdate();
    }

    public PersonalAcc isUser(String username) throws SQLException {
        Statement s = connection.createStatement();
        String query="SELECT username, upassword, companyid FROM users where username='"+username+"'";
        System.out.println("user: "+username);
        System.out.println(query);
        ResultSet r = s.executeQuery(query);

        String userName=null;
        String password=null;

        while(r.next()) {
            userName = r.getString("username");
            password = r.getString("upassword");
            int compId = r.getInt("companyid");
        }
        PersonalAcc acc;

        if(userName.isEmpty()) {
            System.out.println("empty username");
            return null;
        }
        else {
            if(compId==1) {
                System.out.println("recieving personal account with username: "+userName);
                acc = new PersonalAcc(userName);
            }
            else {
                System.out.println("recieving personal account with username: "+userName+ "and compID:"+ compId);
                acc=new BusinessAcc(userName, compId);
            }

            System.out.println("setting pssword:"+password);
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
