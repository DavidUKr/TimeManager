package UI.Controllers;

import components.Task;
import database.DBQueryHandler;
import database.model.PersonalAcc;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.Main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddTaskController {

    @FXML
    DatePicker taskDate;
    @FXML
    TextField taskTitle;
    @FXML
    TextField descriptionTitle;
    @FXML
    Label labelTitle;
    @FXML Label labelDate;
    @FXML Label labelDescription;

    String taskName;
    String taskDescription;
    LocalDate mydate;
    String myFormattedDate;
    MainPageController mainPageController=new MainPageController();
    PersonalAcc personalAcc=new PersonalAcc("ana");
    DBQueryHandler queryHandler;
    public AddTaskController() throws SQLException {
        queryHandler=new DBQueryHandler();
    }

    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    @FXML
    public void closePageWhenAddingTask(MouseEvent event) throws SQLException {
            int status=1;

                taskName = taskTitle.getText();
                if(taskName==null || taskName.length()==0){
                    labelTitle.setTextFill(Color.RED);
                    labelTitle.setText("Please enter a title for the task!");
                    status=0;
                }
                taskDescription = descriptionTitle.getText();

                if(taskDescription==null || taskDescription.length()==0){
                    labelDescription.setTextFill(Color.RED);
                    labelDescription.setText("Please enter a description for the task!");
                    status=0;
                }

            mydate = taskDate.getValue();
            try {
                myFormattedDate = mydate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (NullPointerException e) {
                labelDate.setTextFill(Color.RED);
                labelDate.setText("Please enter a due date for the task!");
                status=0;
            }

            if(status==1){
                Task task = new Task(Main.getUserId(), Main.getCompanyID(),taskName, taskDescription, mydate);
                task.setDueDATE(mydate);
                task.setDESCRIPTION(taskDescription);
                task.setTITLE(taskName);

                if (mainPageController != null) {
                    mainPageController.addDataToTable(task);
                }

                personalAcc.addTasks(task);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }

    }
    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void addTaskToDatabase(Task task){
        try {
            queryHandler.saveTask(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
