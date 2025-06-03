package org.puj.proyectorentcar.Pantalla;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
}
