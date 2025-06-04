package org.puj.proyectorentcar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Negocio.Contrato;

import java.io.IOException;

public class HelloApplication extends Application {
    Contrato contrato = new Contrato();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 410);
        ((IControlador) fxmlLoader.getController()).setContrato(this.contrato);

        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}