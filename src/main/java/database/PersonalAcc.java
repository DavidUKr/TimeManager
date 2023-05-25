package database;

import components.Task;

import java.util.ArrayList;

public class PersonalAcc implements IAccount{
    private int ID;
    private String userName;
    private ArrayList<Task> TASKS;

    public PersonalAcc(){

    }

    public PersonalAcc(int ID, String userName){
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
    public void deleteTask(Task task){

    }

}
