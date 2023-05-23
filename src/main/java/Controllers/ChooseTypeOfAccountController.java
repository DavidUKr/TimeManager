package Controllers;

import UI.ScreenLoaders.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseTypeOfAccountController {

    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    public void goToBussinessAcc(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("/UI/CreateAccount_extended.fxml"));
        scene=new Scene(root);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        PageLoader.setInBussiness(true);
    }

    @FXML
    public void goToPersonalAcc(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("/UI/CreateAccount.fxml"));
        scene=new Scene(root);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        PageLoader.setInBussiness(false);
    }
}
