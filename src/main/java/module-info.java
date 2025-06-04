module org.puj.proyectorentcar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.puj.proyectorentcar to javafx.fxml;
    exports org.puj.proyectorentcar;
}