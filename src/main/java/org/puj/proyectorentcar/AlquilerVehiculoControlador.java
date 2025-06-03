package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.GestorVistas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DateTimeException;
import java.time.chrono.Chronology;

public class AlquilerVehiculoControlador {

    @javafx.fxml.FXML
    private TextField txtPaisActualIngresar;
    @javafx.fxml.FXML
    private TextField txtOficinaRecogidaIngresar;
    @javafx.fxml.FXML
    private DatePicker dateEntrega;
    @javafx.fxml.FXML
    private DatePicker dateDevolucion;
    @javafx.fxml.FXML
    private TextField txtPaisDestinoIngresar;
    @javafx.fxml.FXML
    private TextField txtOficinaDevolucionIngresar;
    @javafx.fxml.FXML
    private TextField txtCiudadOrigenIngresar;
    @javafx.fxml.FXML
    private TextField txtCiudadDestinoIngresar;
    @javafx.fxml.FXML
    private Button btnBuscarVehiculo;

    GestorVistas vistas = new GestorVistas();

    @javafx.fxml.FXML
    public void onClickBuscarVehiculo(ActionEvent actionEvent) {

        try {
            if (!validarCampos())
                return;
            // Conversión de datos SIN EXCEPCIONES
            String PaisActual = txtPaisActualIngresar.getText();
            String OficinaRecogidaIngresar = txtOficinaRecogidaIngresar.getText();
            LocalDate fechaEntrega = dateEntrega.getValue();
            LocalDate fechaDevolucion = dateDevolucion.getValue();
            String PaisDestionoIngresar = txtPaisDestinoIngresar.getText();
            String OficinaDevolucionIngresar =txtOficinaDevolucionIngresar.getText();
            String CiudadOrigenIngresar = txtCiudadOrigenIngresar.getText();
            String CiudadDestinoIngresar =txtCiudadDestinoIngresar.getText();


            try {
                if (fechaDevolucion.isBefore(fechaEntrega)) {
                    throw new DateTimeException(
                            "La fecha de devolución debe ser posterior a la fecha de entrega"
                    );
                }

            } catch (DateTimeException e) {
                vistas.mostrarError("Error de fecha", e.getMessage());
                return;
            }


        } catch (Exception e) {
            // Captura cualquier otra excepción
            vistas.mostrarError("Error inesperado", "Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        }


        }

        private boolean validarCampos() {
        StringBuilder errores = new StringBuilder();

        if (txtPaisActualIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo del pais.\n");
        if (txtOficinaRecogidaIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de la oficina de recogida\n");
        if (dateEntrega.getValue() == null)
            errores.append("Debe seleccionar la fecha de entrega\n");
        if (dateDevolucion.getValue() == null)
            errores.append("Debe seleccionar la fecha de devolución\n");
        if (txtPaisDestinoIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo del pais destino\n");
        if (txtOficinaDevolucionIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de la oficina de devolucion\n");
        if (txtCiudadOrigenIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de la ciudad de origen\n");
        if (txtCiudadDestinoIngresar.getText().trim().isEmpty())
            errores.append("Debe llenar el campo de la ciudad destino\n");
        return true;

    }

    }

