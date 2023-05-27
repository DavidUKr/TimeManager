package main;

import database.repos.UserRepoImpl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{

    private UserRepoImpl database;
    private static int userId;
    private static int companyId;

    public static void main(String[] args) {
        launch(args);
    }

    public static int getCompanyID() {
        return companyId;
    }

    @Override
    public void start(Stage stage) throws Exception {
        database=new UserRepoImpl();


        Parent root= FXMLLoader.load(getClass().getResource("/UI/FirstPage.fxml"));

        Scene scene=new Scene(root);
        stage.setTitle("Time Management");

        Image icon=new Image("/UI/Images/watch2.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

    }

    public static void setUserId(int Id) {
        userId = Id;
    }
    public static void setCompanyId(int Id){
        companyId=Id;
    }

    public static int getUserId(){
        return userId;
    }

    public UserRepoImpl getDatabase(){
        return database;
    }
}