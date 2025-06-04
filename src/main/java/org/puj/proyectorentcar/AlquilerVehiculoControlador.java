package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Dominio.Alquiler;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.Contrato;
import org.puj.proyectorentcar.Negocio.GestorVistas;

import java.time.LocalDate;
import java.time.DateTimeException;


public class AlquilerVehiculoControlador implements IControlador{

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
    Contrato contrato;


    @javafx.fxml.FXML
    public void onClickBuscarVehiculo(ActionEvent actionEvent) {

        try {
            if (!validarCampos())
                return;

            // Conversión de datos SIN EXCEPCIONES
            String paisActual = txtPaisActualIngresar.getText();
            String oficinaRecogidaIngresar = txtOficinaRecogidaIngresar.getText();
            String paisDestionoIngresar = txtPaisDestinoIngresar.getText();
            String oficinaDevolucionIngresar =txtOficinaDevolucionIngresar.getText();
            String ciudadOrigenIngresar = txtCiudadOrigenIngresar.getText();
            String ciudadDestinoIngresar =txtCiudadDestinoIngresar.getText();


            // Conversiones con manejo de errores
            LocalDate fechaEntrega;
            LocalDate fechaDevolucion;


            try {
                fechaEntrega = dateEntrega.getValue();
                fechaDevolucion = dateDevolucion.getValue();
                if (fechaDevolucion.isBefore(fechaEntrega)) {
                    throw new DateTimeException(
                            "La fecha de devolución debe ser posterior a la fecha de entrega"
                    );
                }

                Alquiler alquiler = new Alquiler(ciudadOrigenIngresar,paisActual,paisDestionoIngresar, oficinaRecogidaIngresar, ciudadDestinoIngresar, oficinaDevolucionIngresar, fechaEntrega, fechaDevolucion);
                Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                vistas.abrirVentana("/org/puj/proyectorentcar/seleccion-vehiculo.fxml", "Seleccionar Vehiculo", actual, this.contrato);

            } catch (DateTimeException e) {
                vistas.mostrarError("Error de fecha", e.getMessage());
            }
        } catch (Exception e) {
            // Captura cualquier otra excepción
            vistas.mostrarError("Error inesperado", "Ha ocurrido un error en AlquilerVehiculoControlador: " + e.getMessage());
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
        if (!errores.isEmpty()) {
            vistas.mostrarError("Campos requeridos", errores.toString());
            return false;
        }
        return true;
    }

    // Negocio con la información que se pasó para el controlador
    public void setContrato (Contrato contrato){
        this.contrato = contrato;
    }

}

