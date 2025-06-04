package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.Contrato;
import org.puj.proyectorentcar.Negocio.GestorVistas;

public class SeleccionVehiculoControlador implements IControlador{


    @javafx.fxml.FXML
    private ListView <Vehiculo> listViewVehiculosEncontrados;
    @javafx.fxml.FXML
    private Button btnAgregarSeguro;
    @javafx.fxml.FXML
    private ChoiceBox choiceServiciosAdd;
    @javafx.fxml.FXML
    private ToggleButton toggleSeleccion;
    @javafx.fxml.FXML
    private Button btnAgregarServiciosAdd;
    @javafx.fxml.FXML
    private ListView <Vehiculo> listViewVehiculoSeleccionado;
    @javafx.fxml.FXML
    private Button btnPagar;
    @javafx.fxml.FXML
    private Button btnSeleccionarVehiculo;
    @javafx.fxml.FXML
    private Button btnEliminarVehiculo;
    @javafx.fxml.FXML
    private ChoiceBox choiceSeguro;
    @javafx.fxml.FXML
    private ToggleButton onSeleccionServiciosAdd;

    GestorVistas vistas = new GestorVistas();
    Contrato contrato;

    @Deprecated
    public void onClickAgregarServicio(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickAgregarServiciosAdd(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickEliminarVehiculo(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickSeleccionarServicio(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onSeleccionarSeguro(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickPagar(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickSeleccionarVehiculo(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickAgregarSeguro(ActionEvent actionEvent) {
    }


    @Override
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
