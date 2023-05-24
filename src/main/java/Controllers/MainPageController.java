package Controllers;

import UI.ScreenLoaders.PageLoader;
import components.Task;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;


public class MainPageController implements Initializable{
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            TITLECol.setCellValueFactory(new PropertyValueFactory<Task,String>("TITLE"));
            DESCRIPTIONCol.setCellValueFactory(new PropertyValueFactory<Task,String>("DESCRIPTION"));
            dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDATE"));


            tableView.getColumns().addAll(TITLECol, DESCRIPTIONCol,dueDateCol);
            Task task1=new Task("Clean","CLeanAgain", LocalDate.now());
            tableView.getItems().add(task1);

    }

    public void addDataToTable(Task task) {
        tableView.getItems().add(task);
    }


    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }
    @FXML
    public void goBack(MouseEvent event) throws IOException {

        root= FXMLLoader.load(PageLoader.class.getResource("/UI/Login.fxml"));
        preScene=new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        preScene.getStylesheets().add("/UI/Style.css");
        stage.setScene(preScene);
        stage.show();
    }

    @FXML
    public void addTask(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/addTaskPage.fxml"));
        Parent root = loader.load();
        AddTaskController addTaskController = loader.getController();
        addTaskController.setMainPageController(this);
        Stage stage = new Stage();
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add("/UI/Style.css");
        stage.setScene(newScene);
        stage.show();
    }





}
