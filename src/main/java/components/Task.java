package components;

import javassist.Loader;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class Task {
    private String TITLE;

    private String DESCRIPTION;
    private LocalDate dueDATE;
    private int userID;
    private int companyID;
    private int status; //0 to be done, 1 completed, 2 deleted

    //@Query(value="insert into ")

    public Task(int userID, int companyID, String TITLE, String DESCRIPTION, LocalDate dueDATE){
        this.TITLE=TITLE;
        this.DESCRIPTION=DESCRIPTION;
        this.dueDATE=dueDATE;
        this.userID=userID;
        status=0;
        this.companyID=companyID;
    }
    public Task(int userID, String TITLE, String DESCRIPTION, LocalDate dueDATE){
        this.TITLE=TITLE;
        this.DESCRIPTION=DESCRIPTION;
        this.dueDATE=dueDATE;
        this.userID=userID;
        status=0;
        this.companyID=-1;
    }

    public Task(String TITLE){
        this.TITLE=TITLE;
        status=0;
    }

    public Task(String TITLE, String DESCRIPTION){
        this.TITLE=TITLE;
        this.DESCRIPTION=DESCRIPTION;
        status=0;
    }
    public Task(String TITLE, LocalDate dueDATE){
        this.TITLE=TITLE;
        this.dueDATE=dueDATE;
        status=0;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public LocalDate getDueDATE() {
        return dueDATE;
    }

    public int getStatus() {
        return status;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setDueDATE(LocalDate dueDATE) {
        this.dueDATE = dueDATE;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserID(){
        return userID;
    }

    public int getCompanyID(){
        return companyID;
    }
}
