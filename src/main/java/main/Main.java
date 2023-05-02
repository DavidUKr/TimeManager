package main;

import database.LocalDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.CDATASection;

public class Main extends Application{

    private LocalDatabase database;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        database=new LocalDatabase();

        Parent root= FXMLLoader.load(getClass().getResource("/UI/Login.fxml"));
        Scene scene=new Scene(root);
        scene.getStylesheets().add("/UI/Style.css");
        stage.setScene(scene);
        stage.show();
    }

    public LocalDatabase getDatabase(){
        return database;
    }
}