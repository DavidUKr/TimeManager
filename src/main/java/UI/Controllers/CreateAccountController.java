package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    Label lblCorrect;
    @FXML
    Label lblExists;

    @FXML
    public void goBack(MouseEvent event) throws IOException {

        PageLoader.loadPageMouse(event,pages.FIRST_PAGE);

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
    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
