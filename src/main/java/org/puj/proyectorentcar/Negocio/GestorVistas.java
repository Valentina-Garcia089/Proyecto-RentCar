package org.puj.proyectorentcar.Negocio;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class GestorVistas {
    public void abrirVentana(String rutaFXML, String titulo, Stage pasada){
        try{
            FXMLLoader fxmlloader = new FXMLLoader(GestorVistas.class.getResource(rutaFXML));
            Scene scene = new Scene(fxmlloader.load());
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
            if(pasada != null)
                pasada.close();
        }
        catch(IOException e){
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }


    //mensaje de error
    public void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    //mensaje de bien :)

    /*public void mostrarExito(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }*/
}
