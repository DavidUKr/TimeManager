package database.repos;

import database.model.IAccount;
import jakarta.persistence.QueryHint;

public interface UserRepo {

    public IAccount searchAcc(int ID);
}
