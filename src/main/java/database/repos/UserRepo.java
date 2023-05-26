package database.repos;

import database.model.IAccount;
import jakarta.persistence.QueryHint;

public interface UserRepo {
    @QueryHint(value = "insert into user")
    public IAccount searchAcc(int ID);
}
