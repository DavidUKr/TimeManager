package AccountLoginTests;

import database.model.BusinessAcc;
import database.model.PersonalAcc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBusinessAccount {

    PersonalAcc acc;
    @BeforeEach
    void init(){
        acc=new BusinessAcc("Narcis", 3);
    }

    @Test
    @DisplayName("Test Bus Acc getCompId")
    void TestGetCompId(){
        assertEquals(3, acc.getCompanyId(), ""+acc.getCompanyId());
    }

}
