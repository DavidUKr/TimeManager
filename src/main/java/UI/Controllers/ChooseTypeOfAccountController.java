package UI.Controllers;

import UI.ScreenLoaders.PageLoader;
import UI.ScreenLoaders.pages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
}
