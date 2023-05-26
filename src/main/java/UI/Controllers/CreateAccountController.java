package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import database.model.BusinessAcc;
import database.model.IAccount;
import database.repos.UserRepoImpl;
import database.model.PersonalAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
=======
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
>>>>>>> UI

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
    Label lblCorrect;
    @FXML
    Label lblExists;

<<<<<<< HEAD
    UserRepoImpl database;

=======
    @FXML
    public void goBack(MouseEvent event) throws IOException {

        PageLoader.loadPageMouse(event,pages.FIRST_PAGE);

    }
>>>>>>> UI
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
    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
