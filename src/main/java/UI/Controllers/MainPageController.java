package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import components.Task;
import database.DBQueryHandler;
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
import javafx.stage.StageStyle;
import javafx.util.Callback;
import main.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class MainPageController implements Initializable{

    ArrayList<Task> taskChecked=new ArrayList<>();
    DBQueryHandler queryHandler=new DBQueryHandler();

    @FXML
    private TableView tableView=new TableView<Task>();
    @FXML private TableColumn<Task,String> TITLECol=new TableColumn<Task, String>("Title");
    @FXML private TableColumn<Task, String> DESCRIPTIONCol=new TableColumn<Task, String>("Description");
    @FXML private TableColumn<Task, LocalDate> dueDateCol=new TableColumn<Task,LocalDate>("Date");

    CheckListController checkListController;
    AddTaskController addTaskController;

    public MainPageController() throws SQLException {
        taskChecked.addAll(queryHandler.getCheckedTasks());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            TITLECol.setCellValueFactory(new PropertyValueFactory<Task,String>("TITLE"));
            DESCRIPTIONCol.setCellValueFactory(new PropertyValueFactory<Task,String>("DESCRIPTION"));
            dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDATE"));

            Task task1=new Task(0,"Welcome!","Start managing your time!", LocalDate.now());
            tableView.getItems().add(task1);

        addDeleteButtonToTable();
        addCheckButtonToTable();

        try {
            tableView.getItems().addAll(queryHandler.selectTasks().stream().filter(task2->task2.getUserID()==Main.getUserId()).collect(Collectors.toList()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            tableView.getItems().addAll(queryHandler.getCompanyTasks().stream().filter(task10 -> task10.getCompanyID()!=1).collect(Collectors.toList()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void addDeleteButtonToTable() {
        TableColumn<Task, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Task, Void>, TableCell<Task, Void>> cellFactory = new Callback<TableColumn<Task, Void>, TableCell<Task, Void>>() {
            @Override
            public TableCell<Task, Void> call(final TableColumn<Task, Void> param) {
                final TableCell<Task, Void> cell = new TableCell<Task, Void>() {

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
                            try {
                                DeleteTask(data);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
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
    private void addCheckButtonToTable() {
        TableColumn<Task, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Task, Void>, TableCell<Task, Void>> cellFactory = new Callback<TableColumn<Task, Void>, TableCell<Task, Void>>() {
            @Override
            public TableCell<Task, Void> call(final TableColumn<Task, Void> param) {
                final TableCell<Task, Void> cell = new TableCell<Task, Void>(){


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

                            try {
                                checkedTask(data);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
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

    public void addDataToTable(Task task) throws SQLException {
        tableView.getItems().add(task);
        tableView.getItems().addAll(queryHandler.selectTasks().stream().filter(task2->task2.getUserID()==Main.getUserId()).collect(Collectors.toList()));
        tableView.getItems().addAll(queryHandler.getCompanyTasks().stream().filter(task1 -> task1.getCompanyID()!=1).collect(Collectors.toList()));
        addTaskController.addTaskToDatabase(task);
    }


    public void DeleteTask(Task task) throws SQLException {
        tableView.getItems().remove(task);
        queryHandler.deleteTask(task);
    }

    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goBack(MouseEvent event) throws IOException {

        PageLoader.loadPageMouse(event, pages.LOGIN);

    }

    @FXML
    public void addTask(MouseEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/addTaskPage.fxml"));
        Parent root = loader.load();
        addTaskController = loader.getController();
        addTaskController.setMainPageController(this);
        Stage stage = new Stage();
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add("/UI/Style.css");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        Image icon=new Image("/UI/Images/watch2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Time Management");

        stage.setScene(newScene);
        stage.show();
    }
    public void checkedTask(Task task) throws SQLException {
        task.setStatus(1);
        taskChecked.add(task);
        tableView.getItems().remove(task);
        queryHandler.checkTask(task);
    }

    public ArrayList<Task> getTask(){

        return taskChecked;
    }

    @FXML
    public void getchecklist(MouseEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/doneTasks.fxml"));
        Parent root = loader.load();
        checkListController= loader.getController();
        checkListController.setMainPageController(this);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Time Management");
        Image icon=new Image("/UI/Images/watch2.png");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(icon);
        Scene newScene = new Scene(root);
        stage.setScene(newScene);

        checkListController.Check();
        stage.show();

    }

}
