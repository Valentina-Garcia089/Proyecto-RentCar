package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Dominio.Alquiler;
import org.puj.proyectorentcar.Dominio.PlacaException;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.GestorVistas;

public class RegistrarVehiculoController {

    @javafx.fxml.FXML
    private Slider sldCapacidadMotor;
    @javafx.fxml.FXML
    private Button btnRegistrarVehiculo;
    @javafx.fxml.FXML
    private TextField txtNumPuertasIngresar;
    @javafx.fxml.FXML
    private TextField txtCiudadIngresar;
    @javafx.fxml.FXML
    private TextField txtMarcaIngresar;
    @javafx.fxml.FXML
    private TextField txtPrecioIngresar;
    @javafx.fxml.FXML
    private TextField txtNumSillasIngresar;
    @javafx.fxml.FXML
    private TextField txtTipoVehiculoIngresar;
    @javafx.fxml.FXML
    private TextField txtPaisIngresar;
    @javafx.fxml.FXML
    private TextField txtPlacaIngresar;
    @javafx.fxml.FXML
    private ColorPicker colorVehiculo;
    @javafx.fxml.FXML
    private TextField txtModeloIngresar;


    // CREACIÓN DE OBJETOS
    GestorVistas vistas = new GestorVistas();
    Vehiculo vehiculo;


    @FXML
    public void onClickRegistrarVehiculo(ActionEvent actionEvent) {
        try {
            if (!validarCampos())
                return;

            // Conversión de datos SIN EXCEPCIONES
            String modelo = txtModeloIngresar.getText();
            String ciudad = txtCiudadIngresar.getText();
            String marca = txtMarcaIngresar.getText();
            String tipoVehiculo = txtTipoVehiculoIngresar.getText();
            String paisActual = txtPaisIngresar.getText();
            char[] placa = txtPlacaIngresar.getText().toCharArray();
            String color = String.valueOf(colorVehiculo.getValue());
            float capacidadMotor = Float.parseFloat(String.valueOf(sldCapacidadMotor.getValue()));


            // Posibles excepciones
            int numSillas = 0;
            int numPuertas = 0;
            float precioDia = 0;

            try {
                numSillas = Integer.parseInt(txtNumSillasIngresar.getText());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en número de sillas", "Las sillas deben tener un número valido.\n");
            }

            try {
                numPuertas = Integer.parseInt(txtNumPuertasIngresar.getText());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en número de puertas", "Las puertas deben tener un número valido.\n");
            }

            try {
                precioDia = Float.parseFloat(txtPrecioIngresar.getText());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en precio", "El precio debe tener un valor valido.\n");
            }

            // Ventana actual
            Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Se crea el vehiculo y la siguiente ventana
            vehiculo = new Vehiculo(numSillas, numPuertas, capacidadMotor, color, placa, marca, modelo, precioDia, tipoVehiculo, ciudad, paisActual);
            vistas.abrirVentana("", "", actual);

        } catch (Exception e) {
            // Captura cualquier otra excepción
            vistas.mostrarError("Error inesperado", "Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean validarCampos() {
        StringBuilder errores = new StringBuilder();

        if (txtModeloIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de dirección.\n");
        if (txtNumPuertasIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de numero de puertas\n");
        if (txtCiudadIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de ciudad.\n");
        if (txtMarcaIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de marca");
        if (txtPrecioIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de precio.\n");
        if (txtNumSillasIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de numero de sillas.\n");
        if (txtTipoVehiculoIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de tipo de vehiculo.\n");
        if (txtPaisIngresar.getText().trim().isEmpty())
            errores.append("Debe lleanr el campo de pais.\n");
        if (txtPlacaIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de placa.\n");

        return true;
    }
}
