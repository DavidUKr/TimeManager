package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        Parent root= FXMLLoader.load(getClass().getResource("/UI/Login.fxml"));

        Scene scene=new Scene(root);
        scene.getStylesheets().add("/UI/Style.css");
        stage.setScene(scene);
        stage.show();


    }
}