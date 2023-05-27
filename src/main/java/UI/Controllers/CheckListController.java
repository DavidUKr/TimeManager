package UI.Controllers;

import components.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class CheckListController{

    @FXML
    private TableView tableView=new TableView<Task>();
    @FXML private TableColumn<Task,String> TITLECol=new TableColumn<Task, String>("Title");
    @FXML private TableColumn<Task, String> DESCRIPTIONCol=new TableColumn<Task, String>("Description");
    @FXML private TableColumn<Task, LocalDate> dueDateCol=new TableColumn<Task,LocalDate>("Date");

    MainPageController mainPageController=new MainPageController();

    public CheckListController() throws SQLException {
    }

    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    public void Check(){

        TITLECol.setCellValueFactory(new PropertyValueFactory<Task,String>("TITLE"));
        DESCRIPTIONCol.setCellValueFactory(new PropertyValueFactory<Task,String>("DESCRIPTION"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDATE"));

        addDataToTable();
    }
    public void addDataToTable() {
        ArrayList<Task> taskArrayList=new ArrayList<>();
        if (mainPageController != null) {
           taskArrayList=mainPageController.getTask();
        }
        for(Task task3:taskArrayList){
            tableView.getItems().add(task3);
        }
    }

    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }



}
