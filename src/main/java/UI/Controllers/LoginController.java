package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    Button btnLogin;
    @FXML
    TextField txtFieldUsername;
    @FXML
    TextField txtFieldPassword;
    @FXML
    Button btnCreateAccount;


    Parent root;
    public void login(ActionEvent event) throws IOException {
        System.out.println("Username:"+txtFieldUsername.getText());
        System.out.println("Pass:"+txtFieldPassword.getText());

        PageLoader.loadPage(event, pages.MENU);
    }

    public void gotoCreateAcc(ActionEvent event) throws IOException {

        PageLoader.loadPage(event, pages.CREATE_ACC);
    }
    @FXML
    public void goBack(MouseEvent event) throws IOException{

        root= FXMLLoader.load(PageLoader.class.getResource("/UI/FirstPage.fxml"));
        Scene preScene=new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        preScene.getStylesheets().add("/UI/Style.css");
        stage.setScene(preScene);
        stage.show();

    }
}
