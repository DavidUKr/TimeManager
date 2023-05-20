package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.Text;

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

    static Scene scene;
    static Stage stage;
    static Parent root;

    public void login(ActionEvent event) throws IOException {
        System.out.println("Username:"+txtFieldUsername.getText());
        System.out.println("Pass:"+txtFieldPassword.getText());

        changeToMain(event, "/UI/MainPage.fxml");
    }

    public void gotoCreateAcc(ActionEvent event) throws IOException {

        changeToMain(event, "/UI/CreateAccount.fxml");
    }

    private void changeToMain(ActionEvent event, String path) throws IOException{
        root= FXMLLoader.load(getClass().getResource(path));
        scene=new Scene(root);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
