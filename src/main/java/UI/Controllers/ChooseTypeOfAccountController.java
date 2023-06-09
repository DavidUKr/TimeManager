package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseTypeOfAccountController {
    @FXML
    public void goToBussinessAcc(ActionEvent event) throws IOException {
        PageLoader.loadPage(event, pages.CREATE_ACC);
        PageLoader.setInBussiness(true);
    }
    @FXML
    public void goToPersonalAcc(ActionEvent event) throws IOException {
        PageLoader.loadPage(event, pages.CREATE_ACC);
        PageLoader.setInBussiness(false);

    }

    public void goBack(MouseEvent event) throws IOException{
        PageLoader.loadPageMouse(event,pages.FIRST_PAGE);
    }

    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
