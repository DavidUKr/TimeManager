package database;

import java.util.ArrayList;
import java.util.Iterator;

public class LocalDatabase {
    ArrayList<IAccount> ACCOUNTS;

    public void addAcc(IAccount toAdd){
        ACCOUNTS.add(toAdd);
    }
    public void deleteAcc(IAccount toDelete){
        ACCOUNTS.remove(toDelete);
    }

    public IAccount searchAcc(int ID){
        Iterator searcher=ACCOUNTS.iterator();
        while(searcher.hasNext()){
            IAccount now=(IAccount) searcher.next();
            if(now.getID() == ID) return now;
        }
        return null;
    }
    public IAccount searchAcc(String Name){
        Iterator searcher=ACCOUNTS.iterator();
        while(searcher.hasNext()){
            IAccount now=(IAccount) searcher.next();
            if(now.getUserName().equals(Name)) return now;
        }
        return null;
    }
}
