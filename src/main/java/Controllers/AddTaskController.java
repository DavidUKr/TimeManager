package Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddTaskController {

    @FXML
    public void closePageWhenAddingTask(MouseEvent event){
        MainPageController.mainData(taskName,taskDescription,myFormattedDate);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

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

    public void getInfoOfTaskFromTextField(ActionEvent event){
        taskName=taskTitle.getText();
        taskDescription=descriptionTitle.getText();
        mydate=taskDate.getValue();
        myFormattedDate=mydate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }





}
