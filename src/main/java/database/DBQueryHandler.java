package database;

import components.Task;
import database.model.BusinessAcc;
import database.model.PersonalAcc;
import main.Main;

import javax.swing.*;
import javax.swing.text.TabStop;
import javax.xml.transform.Result;
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
        task_index=getLastTaskID();
        user_index=getLastUserID();
        compId=1;
    }

    public void saveTask(Task task) throws SQLException {
        preparedStatement=connection.prepareStatement("INSERT INTO tasks (id, userid, companyid, title, description, duedate, status) VALUES(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, ++task_index);
        preparedStatement.setInt(2, task.getUserID());
        preparedStatement.setInt(3, task.getCompanyID());
        preparedStatement.setString(4, task.getTITLE());
        preparedStatement.setString(5, task.getDESCRIPTION());
        preparedStatement.setDate(6, Date.valueOf(task.getDueDATE()));
        preparedStatement.setInt(7, task.getStatus());
        //System.out.println(task_index);
        preparedStatement.executeUpdate();
        task.setID(task_index);
    }

    public void saveUser(PersonalAcc user) throws SQLException{
        preparedStatement=connection.prepareStatement("INSERT INTO users (id, companyid, username, upassword) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, ++user_index);
        user.setId(user_index);
        if(user instanceof BusinessAcc){
            compId=((BusinessAcc)user).getCompanyID();
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

    public void checkTask(Task task) throws SQLException {
        preparedStatement=connection.prepareStatement("update tasks set status=1 where id=?");
        preparedStatement.setInt(1, task.getID());
        preparedStatement.executeUpdate();
    }

    public void resetDatabase() throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM useers, tasks");
        preparedStatement.executeUpdate();
        /*preparedStatement=connection.prepareStatement("create table users(" +
                "id int primary key )");*/
    }

    public int getLastTaskID() throws SQLException{
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery("SELECT MAX(id) as id FROM tasks");

        int lastId=0;
        while(r.next()){
            lastId=r.getInt("id");
        }


        return lastId;
    }

    public int getLastUserID() throws SQLException{
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery("SELECT MAX(id) as id FROM users");

        int lastId=0;
        while(r.next()) {
            lastId=r.getInt("id");
        }
        System.out.println(lastId);

        return lastId;
    }

    public List<Task> getCheckedTasks() throws SQLException {
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM tasks WHERE status=1");

        ArrayList<Task> TASKS=new ArrayList<>();
        while(r.next()){
            int id=r.getInt("id");
            int userId= r.getInt("userid");
            int companyId= r.getInt("companyid");
            String title=r.getString("title");
            String description=r.getString("description");
            Date dueDate=r.getDate("duedate");
            String status=r.getString("status");

            TASKS.add(new Task(userId, companyId, title, description, dueDate.toLocalDate()));
        }

        return TASKS;
    }

    public void deleteTask(Task task) throws SQLException {
        preparedStatement=connection.prepareStatement("update tasks set status=2 where id=?");
        preparedStatement.setInt(1, task.getID());
        preparedStatement.executeUpdate();
    }

    public int getUserID(String username) throws SQLException {
        Statement s = connection.createStatement();
        String query="SELECT id FROM users where username='"+username+"'";
        ResultSet r=s.executeQuery(query);

        int id=0;
        while(r.next()){
            id=r.getInt("id");
        }

        return id;
    }

    public int getCoID(String username) throws SQLException {
        Statement s = connection.createStatement();
        String query="SELECT companyid FROM users where username='"+username+"'";
        ResultSet r=s.executeQuery(query);

        int id=0;
        while(r.next()){
            id=r.getInt("companyid");
        }

        return id;
    }

    public List<Task> getCompanyTasks() throws SQLException {
        Statement s = connection.createStatement();
        String query= "SELECT * FROM tasks WHERE companyid="+ Main.getCompanyID();
        ResultSet r = s.executeQuery(query);

        ArrayList<Task> TASKS=new ArrayList<>();
        while(r.next()){
            int id=r.getInt("id");
            int userId= r.getInt("userid");
            int companyId= r.getInt("companyid");
            String title=r.getString("title");
            String description=r.getString("description");
            Date dueDate=r.getDate("duedate");
            String status=r.getString("status");

            TASKS.add(new Task(userId, companyId, title, description, dueDate.toLocalDate()));
        }

        return TASKS;
    }

    public void delUser(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM users WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
