package database.repos;

import database.model.IAccount;

import java.util.ArrayList;
import java.util.Iterator;

public class UserRepoImpl implements UserRepo{
    ArrayList<IAccount> ACCOUNTS;

    //CREATE
    public void addAcc(IAccount toAdd){
        ACCOUNTS.add(toAdd);
    }

    //READ
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
    //UPDATE


    //DELETE
    public void deleteAcc(IAccount toDelete){
        ACCOUNTS.remove(toDelete);
    }
}
