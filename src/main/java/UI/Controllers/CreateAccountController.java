package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AccessibleRole;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.util.Random;


public class CreateAccountController {

    @FXML
    Button btnCreate;
    @FXML
    Button btnTogglePers_Buss;
    @FXML
    Button btnCheck;
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
    @FXML
    Label lblExists;

    public void switchPers_Buss(ActionEvent event) throws IOException {
        PageLoader.loadPage(event, pages.CREATE_ACC);
    }

    public void createAcc(){

        if(txtFieldPassword.getText().equals(txtFieldVerify.getText()))
        System.out.println(txtFieldUsername.getText()+txtFieldPassword.getText());
        else lblCorrect.setText("Not Same");
    }

    Random random=new Random(100);
    public void checkCompany(){
        if(random.nextInt()%2==0)
        lblExists.setText("Found");
        else lblExists.setText("NotFound");
    }
}
