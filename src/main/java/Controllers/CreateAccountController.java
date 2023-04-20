package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;


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
