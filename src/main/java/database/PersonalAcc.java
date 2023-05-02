package database;

import components.Task;

import java.util.ArrayList;

public class PersonalAcc implements IAccount{
    private int ID;
    private String userName;
    ArrayList<Task> TASKS;

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
}
