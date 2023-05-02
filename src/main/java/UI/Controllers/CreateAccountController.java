package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import database.BusinessAcc;
import database.IAccount;
import database.LocalDatabase;
import database.PersonalAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AccessibleRole;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import main.Main;

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

    LocalDatabase database;

    public void switchPers_Buss(ActionEvent event) throws IOException {
        PageLoader.loadPage(event, pages.CREATE_ACC);
    }

    public void createAcc(){
        IAccount ACCOUNT;
        if(!txtFieldPassword.getText().equals(txtFieldVerify.getText()))lblCorrect.setText("Not Same");
        else{
            if(PageLoader.isInBusiness()){
                ACCOUNT=new BusinessAcc(/*Id generator */1, txtFieldUsername.getText(), Integer.parseInt(txtFieldVerify.getText()));
            }
            else {
                ACCOUNT = new PersonalAcc(1, txtFieldUsername.getText());
            }
            database.addAcc(ACCOUNT);
        }
    }

    Random random=new Random(100);
    public void checkCompany(){
        if(random.nextInt()%2==0)
        lblExists.setText("Found");
        else lblExists.setText("NotFound");
    }
}
