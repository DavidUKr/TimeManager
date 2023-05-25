package Controllers;

import components.Task;
import database.PersonalAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddTaskController {



    @FXML
    DatePicker taskDate;
    @FXML
    TextField taskTitle;
    @FXML
    TextField descriptionTitle;

    String taskName;
    String taskDescription;
    LocalDate mydate;
    String myFormattedDate;
    MainPageController mainPageController=new MainPageController();
    PersonalAcc personalAcc=new PersonalAcc(7,"ana");
    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    @FXML
    public void closePageWhenAddingTask(MouseEvent event){

        taskName=taskTitle.getText();
        taskDescription=descriptionTitle.getText();
        mydate=taskDate.getValue();
        myFormattedDate=mydate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
       // System.out.println(taskName+taskDescription+mydate);
        Task task=new Task(taskName,taskDescription,mydate);
        task.setDueDATE(mydate);
        task.setDESCRIPTION(taskDescription);
        task.setTITLE(taskName);

        if (mainPageController != null) {
            mainPageController.addDataToTable(task);
        }

        personalAcc.addTasks( task);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
