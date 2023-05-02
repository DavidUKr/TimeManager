package components;

import java.util.Date;

public class Task {
    public String getTITLE() {
        return TITLE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public Date getDueDATE() {
        return dueDATE;
    }

    public int getStatus() {
        return status;
    }

    private String TITLE;

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setDueDATE(Date dueDATE) {
        this.dueDATE = dueDATE;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String DESCRIPTION;
    private Date dueDATE;

    private int status; //0 to be done, 1 completed, 2 deleted

    public Task(String TITLE, String DESCRIPTION, Date dueDATE){
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
    public Task(String TITLE, Date dueDATE){
        this.TITLE=TITLE;
        this.dueDATE=dueDATE;
        status=0;
    }

}
