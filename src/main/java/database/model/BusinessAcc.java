package database.model;

public class BusinessAcc extends PersonalAcc{
    private int comp_ID;

    public BusinessAcc(int ID, String userName, int comp_ID){
        super(ID, userName);
        this.comp_ID=comp_ID;
    }
    public int getComp_ID() {
        return comp_ID;
    }
}
