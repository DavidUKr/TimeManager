package database.model;

import components.Task;

import java.util.ArrayList;

public class PersonalAcc implements IAccount{
    private int ID;
    private String userName;
    private ArrayList<Task> TASKS;
    private String password;
    private int companyId=1;

    public PersonalAcc(String userName){
        this.ID=ID;
        this.userName=userName;
        TASKS=new ArrayList<Task>();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public ArrayList<Task> getTasks() {
        return TASKS;
    }

    public void addTasks(Task task){
        TASKS.add(task);
        System.out.println(task.getTITLE()+"\n"+task.getDESCRIPTION()+"\n"+task.getDueDATE()+"\n");
    }


    public void setId(int userIndex) {
        ID=userIndex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompanyId(int compId) {
        companyId=compId;
    }

    public int getCompanyId(){
        return companyId;
    }
}
