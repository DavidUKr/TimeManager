package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {

    Scene scene;
    Stage stage;
    Parent root;
    @FXML
    public void gotoCreateAcc(ActionEvent event) throws IOException {

        changeToMain(event, "/UI/ChooseTypeOfAccountToCreate.fxml");
    }

    @FXML
    public void gotoLogin(ActionEvent event) throws IOException {

        changeToMain(event, "/UI/Login.fxml");
    }
    private void changeToMain(ActionEvent event, String path) throws IOException {



        root= FXMLLoader.load(getClass().getResource(path));
        scene=new Scene(root);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene.getStylesheets().add("/UI/Style.css");
        stage.setScene(scene);
        stage.show();
    }
}
