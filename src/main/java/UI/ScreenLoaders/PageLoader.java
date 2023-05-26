package UI.ScreenLoaders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PageLoader {

    private static Scene scene;
    private static Stage stage;
    private static Parent root;
    private static String FXMLpath;

    private static boolean inBusiness;
    public  static void setInBussiness(boolean setvalue){
        inBusiness=setvalue;
    }
    public static void setPage(pages page){
        switch(page){
            case LOGIN ->{
                FXMLpath="/UI/Login.fxml";
            }
            case MENU ->{
                FXMLpath="/UI/MainPage.fxml";
            }
            case CHOOSE_TYPE_ACC -> {
                FXMLpath="/UI/ChooseTypeOfAccountToCreate.fxml";
            }
            case FIRST_PAGE -> {
               FXMLpath="/UI/FirstPage.fxml";
            }
            case CREATE_ACC ->{
                if(inBusiness){
                    FXMLpath="/UI/CreateAccount.fxml";
                    inBusiness=false;
                }
                else {
                    FXMLpath="/UI/CreateAccount_extended.fxml";
                    inBusiness=true;
                }
            }


        }
    }

    public static void loadPage(ActionEvent event, pages page) throws IOException {

        setPage(page);

        root= FXMLLoader.load(PageLoader.class.getResource(FXMLpath));

        scene=new Scene(root);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
    public static void loadPageMouse(MouseEvent event, pages page) throws IOException {

        setPage(page);

        root= FXMLLoader.load(PageLoader.class.getResource(FXMLpath));

        scene=new Scene(root);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }


}
