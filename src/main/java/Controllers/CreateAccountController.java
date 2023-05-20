package Controllers;


import UI.ScreenLoaders.PageLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class CreateAccountController {

    @FXML
    Button btnCreate;
    @FXML
    ToggleButton btnTogglePers_Buss;
    @FXML
    TextField txtFieldUsername;
    @FXML
    TextField txtFieldPassword;
    @FXML
    TextField txtFieldVerify;
    @FXML
    Label lblStatus;
    @FXML
    Label lblCorrect;


    Scene preScene;
    Parent root;
    public void switchPers_Buss(){
        if(lblStatus.getText().equals("Personal")) lblStatus.setText("Business");
        else lblStatus.setText("Personal");
    }

    public void createAcc(){

        if(txtFieldPassword.getText().equals(txtFieldVerify.getText()))
        System.out.println(txtFieldUsername.getText()+txtFieldPassword.getText());
        else lblCorrect.setText("Not Same");
    }



}
