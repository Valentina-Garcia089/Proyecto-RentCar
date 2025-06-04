package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.Contrato;
import org.puj.proyectorentcar.Negocio.GestorVistas;

import java.util.ArrayList;

public class SeleccionVehiculoControlador implements IControlador{


    @javafx.fxml.FXML
    private ListView <Vehiculo> listViewVehiculosEncontrados;
    @javafx.fxml.FXML
    private Button btnAgregarSeguro;
    @javafx.fxml.FXML
    private ChoiceBox choiceServiciosAdd;
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
    private ToggleButton toggleSeleccionSeguro;
    @javafx.fxml.FXML
    private ToggleButton toggleSeleccionServiciosAdd;

    GestorVistas vistas = new GestorVistas();
    Contrato contrato;

    public void initialize(){
        ArrayList <Vehiculo> traerVehiculos = contrato.leerArchivoVehiculos("Data/Vehiculos.txt");
        if (traerVehiculos != null) {
            listViewVehiculosEncontrados.getItems().addAll(traerVehiculos);
        }

        // Desactivar los choiceBox por defecto hasta que este tenga un valor especifico
        choiceSeguro.setDisable(true);
        btnAgregarSeguro.setDisable(true);
        toggleSeleccionSeguro.setText("No");

        choiceServiciosAdd.setDisable(true);
        btnAgregarServiciosAdd.setDisable(true);
        toggleSeleccionServiciosAdd.setText("No");

        // Función flecha para activar los choiceBox cuando los toggles también estén activos
        toggleSeleccionSeguro.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected){
                choiceSeguro.setDisable(false);
                btnAgregarSeguro.setDisable(false);
                toggleSeleccionSeguro.setText("Si");
            }else {
                choiceSeguro.setDisable(true);
                btnAgregarSeguro.setDisable(true);
                toggleSeleccionSeguro.setText("No");;
                choiceSeguro.getSelectionModel().clearSelection();
            }
        });

        toggleSeleccionServiciosAdd.selectedProperty().addListener((obs, wasSelected, isNowSelected)->{
            if (isNowSelected){
                choiceServiciosAdd.setDisable(false);
                btnAgregarServiciosAdd.setDisable(false);
                toggleSeleccionServiciosAdd.setText("Si");
            }else {
                choiceServiciosAdd.setDisable(true);
                btnAgregarServiciosAdd.setDisable(true);
                toggleSeleccionServiciosAdd.setText("No");
                choiceServiciosAdd.getSelectionModel().clearSelection();
            }
        });
    }


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

    @Deprecated
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

    @javafx.fxml.FXML
    public void onClickSeleccionarSeguro(ActionEvent actionEvent) {
    }
}
