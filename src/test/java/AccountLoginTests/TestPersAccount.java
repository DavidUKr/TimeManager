package AccountLoginTests;

import UI.Controllers.MainPageController;
import components.Task;
import database.model.PersonalAcc;
import main.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPersAccount{

    PersonalAcc pers;
    @BeforeEach
    void init(){
        pers=new PersonalAcc("testacc");
        Task task=new Task("Do Stuff");
        pers.addTasks(task);
        pers.setPassword("123");
    }

    @Test
    @DisplayName("Test register personale account")
    void TestTaskAdd(){
        assertNotNull(pers.getTasks());
    }

    @Test
    @DisplayName("Test password storage")
    void TestPassword(){
        assertEquals("123", pers.getPassword());
    }
}
