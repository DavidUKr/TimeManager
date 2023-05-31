package DatabaseTests;

import UI.Controllers.MainPageController;
import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import components.Task;
import database.DBQueryHandler;
import database.model.PersonalAcc;
import javafx.event.ActionEvent;
import main.Main;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDBDataEschange {

    static DBQueryHandler qHand;
    static PersonalAcc user;
    static List<Task> TASKS;
    MainPageController mainPageController;
    @BeforeAll
    static void init() throws SQLException, IOException {
        qHand=new DBQueryHandler();
        user=new PersonalAcc("MilkyWay");
        user.setPassword("123");
        qHand.saveUser(user);
        Main.setUserId(user.getID());
        Main.setCompanyId(1);

        TASKS=new ArrayList<>();
        TASKS.addAll(List.of(new Task(1,1,"task1", "dotask1", LocalDate.now()), new Task(1,1,"task2", "dotask2", LocalDate.now())));

        for(Task t:TASKS) qHand.saveTask(t);

        //mainPageController=new MainPageController();
        //PageLoader.loadPage(new ActionEvent(), pages.MENU);
    }

   /* @AfterAll
    void clean() throws SQLException {
        qHand.delUser(user.getID());
    }*/

    @Test
    @DisplayName("Test saveUser")
    void TestGetUser() throws SQLException {
        assertEquals(user.getID(), qHand.getUserID(user.getUserName()));
    }

    @Test
    @DisplayName("TestAccountVerif")
    void TestAuthentification() throws SQLException {
        assertEquals(user.getID(), qHand.isUser(user.getUserName()).getID());
    }

    @Test
    @DisplayName("Testing getTesks for added tasks")
    void TestGetTasks()throws SQLException{
        assertEquals(TASKS.size(), qHand.selectTasks().size());
    }

    @Test
    @DisplayName("test get last task")
    void TestLastTaskID() throws SQLException {
        assertEquals(TASKS.get(1).getID(), qHand.getLastTaskID());
    }

    @Test
    @DisplayName("Test get last user id")
    void TestLastUserID() throws SQLException{
        assertEquals(user.getID(), qHand.getLastUserID());
    }

    /*@Test
    @DisplayName("Test Checked tasks")
    void TestCheckedTasks() throws SQLException{
        ArrayList<Integer> ids=new ArrayList<>();
        for(Task t:TASKS) {
            mainPageController.checkedTask(t);
            ids.add(t.getID());
        }

        ArrayList<Integer> ids_check=new ArrayList<>();
        ArrayList<Task> checked=(ArrayList<Task>)qHand.getCheckedTasks();
        for(Task t:checked){
            ids_check.add(t.getID());
        }

        for(Integer id:ids) {
            assertTrue(ids_check.contains(id));
        }
    }*/

    @Test
    @DisplayName("test company id")
    void TestGetCompId() throws SQLException {
        assertEquals(1, qHand.getCoID(user.getUserName()));
    }
}
