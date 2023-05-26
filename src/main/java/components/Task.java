package components;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class Task {
    private String TITLE;

    private String DESCRIPTION;
    private LocalDate dueDATE;

    private int status; //0 to be done, 1 completed, 2 deleted

    //@Query(value="insert into ")
    public Task(String TITLE, String DESCRIPTION, LocalDate dueDATE){
        this.TITLE=TITLE;
        this.DESCRIPTION=DESCRIPTION;
        this.dueDATE=dueDATE;
        status=0;
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

}
