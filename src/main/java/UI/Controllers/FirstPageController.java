package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class FirstPageController {

    @FXML
    public void gotoCreateAcc(ActionEvent event) throws IOException {
        PageLoader.loadPage(event, pages.CHOOSE_TYPE_ACC);
    }

    @FXML
    public void gotoLogin(ActionEvent event) throws IOException {
        PageLoader.loadPage(event,pages.LOGIN);
    }

}
