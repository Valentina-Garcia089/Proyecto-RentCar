package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Dominio.Seguro;
import org.puj.proyectorentcar.Dominio.ServiciosAdd;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.Contrato;
import org.puj.proyectorentcar.Negocio.GestorVistas;

import java.util.ArrayList;

public class SeleccionAdicionalControlador implements IControlador {

    @javafx.fxml.FXML
    private ListView <Seguro> listViewSeguros;
    @javafx.fxml.FXML
    private Button btnEliminarServicio;
    @javafx.fxml.FXML
    private Button btnAgregarSeguro;
    @javafx.fxml.FXML
    private ChoiceBox <ServiciosAdd> choiceServiciosAdd;
    @javafx.fxml.FXML
    private ListView <ServiciosAdd>listViewServicios;
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
    private ChoiceBox <Seguro> choiceSeguro;

    // Objetos
    GestorVistas vistas = new GestorVistas();
    Contrato contrato;


    public void initialize(){
        ArrayList<Seguro> listarSeguros = new ArrayList<>();
        listarSeguros.add(new Seguro ("Sin seguro"));
        listarSeguros.add(new Seguro("seguro llantas"));
        listarSeguros.add(new Seguro("seguro vidrios"));
        listarSeguros.add(new Seguro("todo riesgo"));

        ArrayList <ServiciosAdd> listarServiciosAdd = new ArrayList<>();
        listarServiciosAdd.add(new ServiciosAdd("conductor adicional"));
        listarServiciosAdd.add(new ServiciosAdd("silla bebe"));
        listarServiciosAdd.add(new ServiciosAdd("maletero"));
        listarServiciosAdd.add(new ServiciosAdd("gps"));

        // Desactivar los choiceBox por defecto hasta que este tenga un valor especifico
        choiceSeguro.setDisable(true);
        btnAgregarSeguro.setDisable(true);
        listViewSeguros.setDisable(true);
        toggleSeleccionSeguro.setText("No");

        choiceServiciosAdd.setDisable(true);
        btnAgregarServiciosAdd.setDisable(true);
        listViewServicios.setDisable(true);
        toggleSeleccionServiciosAdd.setText("No");

        // Función flecha para activar los choiceBox cuando los toggles también estén activos
        toggleSeleccionSeguro.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected){
                choiceSeguro.setDisable(false);
                btnAgregarSeguro.setDisable(false);
                listViewSeguros.setDisable(false);
                toggleSeleccionSeguro.setText("Si");
                choiceSeguro.getItems().addAll(listarSeguros);
            }else {
                choiceSeguro.setDisable(true);
                btnAgregarSeguro.setDisable(true);
                listViewSeguros.setDisable(true);
                toggleSeleccionSeguro.setText("No");;
                choiceSeguro.getSelectionModel().clearSelection();
            }
        });

        toggleSeleccionServiciosAdd.selectedProperty().addListener((obs, wasSelected, isNowSelected)->{
            if (isNowSelected){
                choiceServiciosAdd.setDisable(false);
                btnAgregarServiciosAdd.setDisable(false);
                listViewServicios.setDisable(false);
                toggleSeleccionServiciosAdd.setText("Si");
                choiceServiciosAdd.getItems().addAll(listarServiciosAdd);
            }else {
                choiceServiciosAdd.setDisable(true);
                btnAgregarServiciosAdd.setDisable(true);
                listViewServicios.setDisable(true);
                toggleSeleccionServiciosAdd.setText("No");
                choiceServiciosAdd.getSelectionModel().clearSelection();
            }
        });
    }


    @javafx.fxml.FXML
    public void onClickAgregarServiciosAdd(ActionEvent actionEvent) {
        ServiciosAdd item = choiceServiciosAdd.getValue();
        if(item != null){
            listViewServicios.getItems().add(item);
        }
        else{
            vistas.mostrarError("Campo vacio","Seleccione un servicio de la lista");
        }
    }

    @javafx.fxml.FXML
    public void onClickAgregarSeguro(ActionEvent actionEvent) {
        Seguro item = choiceSeguro.getValue();
        if(item != null){
            listViewSeguros.getItems().add(item);
        }
        else{
            vistas.mostrarError("Campo vacio","Seleccione un seguro de la lista");
        }
    }

    @javafx.fxml.FXML
    public void onClickEliminarSeguro(ActionEvent actionEvent) {
        Seguro seleccionado = listViewSeguros.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listViewSeguros.getItems().remove(seleccionado);
        } else {
            vistas.mostrarError("Sin selección","Selecciona el seguro a eliminar.");
        }
    }

    @Deprecated
    public void onClickEliminarSericio(ActionEvent actionEvent) {
        ServiciosAdd seleccionado = listViewServicios.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listViewServicios.getItems().remove(seleccionado);
        } else {
            vistas.mostrarError("Sin selección","Selecciona el servicio a eliminar.");
        }
    }

    @javafx.fxml.FXML
    public void onClickPagar(ActionEvent actionEvent) {
        //boolean siguientePagina = true;
        if((!listViewSeguros.getItems().isEmpty())){
            ArrayList <Seguro> listaSeguros = new ArrayList<>(listViewSeguros.getItems());
            contrato.setListaSeguros(listaSeguros);
        }
        else {
            vistas.mostrarError("Vehiculo no seleccionado", "Debe seleccionar un vehiculo para continuar");
        }

        if((!listViewServicios.getItems().isEmpty())){
            ArrayList <ServiciosAdd> listaServicios = new ArrayList<>(listViewServicios.getItems());
            contrato.setListaServiciosAdd(listaServicios);
        }
        else {
            vistas.mostrarError("Vehiculo no seleccionado", "Debe seleccionar un vehiculo para continuar");
        }

        Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        vistas.abrirVentana("/org/puj/proyectorentcar/pago.fxml", "Pago", actual, this.contrato);
    }

    @javafx.fxml.FXML
    public void onClickEliminarServicio(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickSeleccionarSeguro(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onClickSeleccionarServicio(ActionEvent actionEvent) {
    }


    @Override
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
