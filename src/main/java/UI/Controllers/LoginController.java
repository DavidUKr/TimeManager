package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    public void login(ActionEvent event) throws IOException {
        System.out.println("Username:"+txtFieldUsername.getText());
        System.out.println("Pass:"+txtFieldPassword.getText());

        PageLoader.loadPage(event, pages.MENU);
    }
    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    public void goBack(MouseEvent event) throws IOException{

        PageLoader.loadPageMouse(event,pages.FIRST_PAGE);

    }
}
