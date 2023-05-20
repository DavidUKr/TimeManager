package Controllers;

import UI.ScreenLoaders.PageLoader;
import components.Task;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainPageController implements Initializable{


    @FXML
    private TableView<Task> tableView;
    @FXML private TableColumn<Task,String> TITLECol;
    @FXML private TableColumn<Task, String> DESCRIPTIONCol;
    @FXML private TableColumn<Task, Date> dueDateCol;
    Scene preScene;
    Parent root;
    ObservableList<Task> TaskList=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TITLECol.setCellValueFactory(new PropertyValueFactory<Task,String>("TITLE"));
        DESCRIPTIONCol.setCellValueFactory(new PropertyValueFactory<Task,String>("DESCRIPTION"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));

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
        root= FXMLLoader.load(PageLoader.class.getResource("/UI/addTaskPage.fxml"));
        Stage stage=new Stage();
        Scene newScene=new Scene(root);
        newScene.getStylesheets().add("/UI/Style.css");
        stage.setScene(newScene);
        stage.show();


    }



}
