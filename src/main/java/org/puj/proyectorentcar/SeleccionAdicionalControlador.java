package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import org.puj.proyectorentcar.Dominio.Seguro;
import org.puj.proyectorentcar.Negocio.Contrato;

public class SeleccionAdicionalControlador implements IControlador {

    @javafx.fxml.FXML
    private ListView listViewSeguros;
    @javafx.fxml.FXML
    private Button btnEliminarServicio;
    @javafx.fxml.FXML
    private Button btnAgregarSeguro;
    @javafx.fxml.FXML
    private ChoiceBox choiceServiciosAdd;
    @javafx.fxml.FXML
    private ListView listViewServicios;
    @javafx.fxml.FXML
    private ToggleButton toggleSeleccionServiciosAdd;
    @javafx.fxml.FXML
    private Button btnAgregarServiciosAdd;
    @javafx.fxml.FXML
    private Button btnEliminarSeguro;
    @javafx.fxml.FXML
    private ToggleButton toggleSeleccionSeguro;
    @javafx.fxml.FXML
    private Button btnPagar;
    @javafx.fxml.FXML
    private ChoiceBox choiceSeguro;

    // Objetos
    Contrato contrato;


    public void initialize(){
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
                //choiceSeguro.getItems().addAll(new Seguro())
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


    @javafx.fxml.FXML
    public void onClickAgregarServiciosAdd(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickEliminarSeguro(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickSeleccionarServicio(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickEliminarSericio(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickSeleccionarSeguro(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickPagar(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickAgregarSeguro(ActionEvent actionEvent) {
    }


    @Override
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
