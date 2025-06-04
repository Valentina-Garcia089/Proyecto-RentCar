package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Dominio.Alquiler;
import org.puj.proyectorentcar.Negocio.Contrato;
import org.puj.proyectorentcar.Negocio.GestorVistas;

import java.time.LocalDate;

import java.time.DateTimeException;



public class PagoControlador implements IControlador {
    @javafx.fxml.FXML
    private TextField txtNombreIngresar;
    @javafx.fxml.FXML
    private DatePicker dateVencimiento;
    @javafx.fxml.FXML
    private TextField txtNumCuotasIngresar;
    @javafx.fxml.FXML
    private TextField txtApellidoIngresar;
    @javafx.fxml.FXML
    private TextField txtNumTarjetaIngresar;
    @javafx.fxml.FXML
    private Button btnPagar;
    @javafx.fxml.FXML
    private TextField txtFranquiciaIngresar;
    @FXML
    private PasswordField pwdVencimiento;

    GestorVistas vistas = new GestorVistas();
    Contrato contrato;

    @javafx.fxml.FXML
    public void onClickPagar(ActionEvent actionEvent) {

        try {
            if (!validarCampos())
                return;

            // Conversión de datos SIN EXCEPCIONES
            String NombreIngresar = txtNombreIngresar.getText();
            Integer NumcuotasIngresar= Integer.valueOf(txtNumCuotasIngresar.getText());
            String ApellidoIgresar= txtApellidoIngresar.getText();
            String FranquiciaIngresar = txtFranquiciaIngresar.getText();


            // Conversiones con manejo de errores
            LocalDate vencimiento;

            long NumTarjetaIngresar;
            int NumCuotas;
            int CVV;

            try {
                vencimiento = dateVencimiento.getValue();
                LocalDate fechaHoy = LocalDate.now();
                if (vencimiento.isBefore(fechaHoy) || vencimiento.isEqual(fechaHoy)) {
                    throw new DateTimeException(
                            "La fecha de vencimiento debe ser posterior a la fecha de hoy"
                    );
                }

            } catch (DateTimeException e) {
                vistas.mostrarError("Error de fecha", e.getMessage());
            }

            try {
                NumTarjetaIngresar = Long.parseLong(txtNumTarjetaIngresar.getText().trim());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en número de ID", "El número de ID debe ser solo números");
                return;
            }

            try {
                CVV = Integer.parseInt(pwdVencimiento.getText().trim());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en edad", "La CVV debe ser un numero valido");
                return;
            }

            try {
                NumCuotas = Integer.parseInt(txtNumCuotasIngresar.getText().trim());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en edad", "La cantidad de cuotas debe ser un numero valido");
                return;
            }


        }catch (Exception e) {
        // Captura cualquier otra excepción
        vistas.mostrarError("Error inesperado", "Ha ocurrido un error: " + e.getMessage());
        e.printStackTrace();
    }

    }

    private boolean validarCampos() {
        StringBuilder errores = new StringBuilder();

        if (txtNombreIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo del nombre.\n");
        if (txtApellidoIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo del apellido\n");
        if (dateVencimiento.getValue() == null)
            errores.append("Debe seleccionar la fecha de vencimiento de la tarjeta\n");
        if (pwdVencimiento.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de la contraseña\n");
        if (txtNumTarjetaIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo del numero de la tarjeta\n");
        if (txtFranquiciaIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de la franquicia de la tarjeta\n");
        if (txtNumCuotasIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar la cantidad de cuotas\n");

        if (!errores.isEmpty()) {
            vistas.mostrarError("Campos requeridos", errores.toString());
            return false;
        }
        return true;

    }
    public void setContrato (Contrato contrato){
        this.contrato = contrato;
    }
}
