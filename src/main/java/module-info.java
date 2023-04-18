module main.timemanager {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens main.timemanager to javafx.fxml;
    exports main.timemanager;
}