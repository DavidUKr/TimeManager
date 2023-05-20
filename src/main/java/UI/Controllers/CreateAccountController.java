package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleRole;
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

    Parent root;
    Scene preScene;

    @FXML
    public void goBack(MouseEvent event) throws IOException {

        root= FXMLLoader.load(PageLoader.class.getResource("/UI/Login.fxml"));
        preScene=new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(preScene);
        stage.show();
    }
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
