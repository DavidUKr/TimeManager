package database.model;

import main.Main;

public class BusinessAcc extends PersonalAcc{

    public BusinessAcc(String userName, int comp_ID){
        super(userName);
        super.setCompanyId(comp_ID);
        Main.setCompanyId(comp_ID);
    }
    public int getCompanyID() {
        return super.getCompanyId();
    }
}
