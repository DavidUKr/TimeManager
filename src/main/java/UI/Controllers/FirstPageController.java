package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {

    @FXML
    public void gotoCreateAcc(ActionEvent event) throws IOException {
        PageLoader.loadPage(event, pages.CHOOSE_TYPE_ACC);
    }
    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void gotoLogin(ActionEvent event) throws IOException {
        PageLoader.loadPage(event,pages.LOGIN);
    }

}
