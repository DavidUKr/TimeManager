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


public class MainPageController implements Initializable{
    private static String taskName;
    private static String taskDescription;
    private static String mydate;
    private static Task task;
    String myFormattedDate;
    Scene preScene;
    Parent root;
    ObservableList<Task> TaskList=FXCollections.observableArrayList();
    ArrayList<Task> taskChecked=new ArrayList<>();


    @FXML
    private TableView tableView=new TableView<Task>();
    @FXML private TableColumn<Task,String> TITLECol=new TableColumn<Task, String>("Title");
    @FXML private TableColumn<Task, String> DESCRIPTIONCol=new TableColumn<Task, String>("Description");
    @FXML private TableColumn<Task, LocalDate> dueDateCol=new TableColumn<Task,LocalDate>("Date");
    @FXML Button btnCheckList;
    CheckListController checkListController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            TITLECol.setCellValueFactory(new PropertyValueFactory<Task,String>("TITLE"));
            DESCRIPTIONCol.setCellValueFactory(new PropertyValueFactory<Task,String>("DESCRIPTION"));
            dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDATE"));


//            tableView.getColumns().addAll(TITLECol, DESCRIPTIONCol,dueDateCol);
            Task task1=new Task("Clean","CLeanAgain", LocalDate.now());
            tableView.getItems().add(task1);
            addButtonToTable();

            addButtonToTable2();

    }

    private void addButtonToTable() {
        TableColumn<Task, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Task, Void>, TableCell<Task, Void>> cellFactory = new Callback<TableColumn<Task, Void>, TableCell<Task, Void>>() {
            @Override
            public TableCell<Task, Void> call(final TableColumn<Task, Void> param) {
                final TableCell<Task, Void> cell = new TableCell<Task, Void>() {

                    FileInputStream input;

                    {
                        try {
                            input = new FileInputStream("src/main/resources/UI/Images/checkbox.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    Image image = new Image(input);

                    ImageView imageView = new ImageView(image);

                    //  btn.setGraphic(imageView);
                    private final Button btn = new Button();

                    {
                        btn.setPrefWidth(10);
                        btn.setPrefHeight(10);
                        btn.setStyle("-fx-border-color: transparent; -fx-border-width: 0;-fx-background-color: transparent;");
                        imageView.setFitWidth(20);
                        imageView.setFitHeight(20);
                        btn.setGraphic(imageView);
                        btn.setOnAction((ActionEvent event) -> {
                            Task data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data.getTITLE()+data.getDESCRIPTION()+data.getDueDATE());
                            data.setStatus(2);
                            DeleteTask(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableView.getColumns().add(colBtn);

    }
    private void addButtonToTable2() {
        TableColumn<Task, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Task, Void>, TableCell<Task, Void>> cellFactory = new Callback<TableColumn<Task, Void>, TableCell<Task, Void>>() {
            @Override
            public TableCell<Task, Void> call(final TableColumn<Task, Void> param) {
                final TableCell<Task, Void> cell = new TableCell<Task, Void>(){


                    FileInputStream input;

                    {
                        try {
                            input = new FileInputStream("src/main/resources/UI/Images/trash.png");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    Image image = new Image(input);

                    ImageView imageView = new ImageView(image);

                  //  btn.setGraphic(imageView);
                  private final Button btn = new Button();

                    {
                        btn.setPrefWidth(8);
                        btn.setPrefHeight(8);
                        btn.setStyle("-fx-border-color: transparent; -fx-border-width: 0;-fx-background-color: transparent;");
                        imageView.setFitWidth(20);
                        imageView.setFitHeight(20);
                        btn.setGraphic(imageView);
                        btn.setOnAction((ActionEvent event) -> {
                            Task data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data.getTITLE()+data.getDESCRIPTION()+data.getDueDATE());
                            data.setStatus(1);

                            checkedTask(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }


                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableView.getColumns().add(colBtn);

    }

    public void addDataToTable(Task task) {
        tableView.getItems().add(task);
    }


    public void DeleteTask(Task task){
        tableView.getItems().remove(task);
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
    public void checkedTask(Task task){
        if (checkListController != null) {
           taskChecked.add(task);
        }
        tableView.getItems().remove(task);
    }

    @FXML
    public void getchecklist(MouseEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/doneTasks.fxml"));
        Parent root = loader.load();

        checkListController = loader.getController();
        checkListController.setMainPageController(this);
        Stage stage = new Stage();
        Scene newScene = new Scene(root);
        stage.setScene(newScene);

        stage.show();
        checkListController.addDataToTable(taskChecked);
    }

}
