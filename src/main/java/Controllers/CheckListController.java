package Controllers;

import UI.ScreenLoaders.PageLoader;
import components.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class CheckListController{
    private static String taskName;
    private static String taskDescription;
    private static String mydate;
    private static Task task;
    String myFormattedDate;
    Scene preScene;
    Parent root;
    static ObservableList<Task> TaskList=FXCollections.observableArrayList();

    @FXML
    private TableView tableView=new TableView<Task>();
    @FXML private TableColumn<Task,String> TITLECol=new TableColumn<Task, String>("Title");
    @FXML private TableColumn<Task, String> DESCRIPTIONCol=new TableColumn<Task, String>("Description");
    @FXML private TableColumn<Task, LocalDate> dueDateCol=new TableColumn<Task,LocalDate>("Date");

    MainPageController mainPageController=new MainPageController();
    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    public void Check(Stage stage){

        TITLECol.setCellValueFactory(new PropertyValueFactory<Task,String>("TITLE"));
        DESCRIPTIONCol.setCellValueFactory(new PropertyValueFactory<Task,String>("DESCRIPTION"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDATE"));

        Task task1=new Task("Clean","CLeanAgain", LocalDate.now());
        tableView.getItems().add(task1);
        addDataToTable();
    }








    public void addDataToTable() {
        ArrayList<Task> taskArrayList=new ArrayList<>();
        if (mainPageController != null) {
           taskArrayList=mainPageController.getTask();
        }

        for(Task task3:taskArrayList){
            tableView.getItems().add(task3);
            System.out.println(task3.getTITLE()+task3.getDESCRIPTION());
        }
        Task task2=new Task("Clean","CLeanAgain", LocalDate.now());
        tableView.getItems().add(task2);

    }




    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }



}
