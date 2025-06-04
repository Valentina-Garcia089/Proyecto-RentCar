package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.Contrato;
import org.puj.proyectorentcar.Negocio.GestorVistas;
import org.puj.proyectorentcar.Util.GestorArchivos;

import java.util.ArrayList;
import java.util.Arrays;

public class SeleccionVehiculoControlador implements IControlador{


    @javafx.fxml.FXML
    private ListView <Vehiculo> listViewVehiculosEncontrados;
    @javafx.fxml.FXML
    private ListView <Vehiculo> listViewVehiculoSeleccionado;
    @javafx.fxml.FXML
    private Button btnPagar;
    @javafx.fxml.FXML
    private Button btnSeleccionarVehiculo;
    @javafx.fxml.FXML
    private Button btnEliminarVehiculo;

    GestorVistas vistas = new GestorVistas();
    Contrato contrato;



    @javafx.fxml.FXML
    public void onClickEliminarVehiculo(ActionEvent actionEvent) {
        Vehiculo seleccionado = listViewVehiculoSeleccionado.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listViewVehiculoSeleccionado.getItems().remove(seleccionado);
        } else {
            vistas.mostrarError("Sin selección","Selecciona el vehiculo de la derecha para eliminar.");
        }

    }


    @javafx.fxml.FXML
    public void onClickSeleccionarVehiculo(ActionEvent actionEvent) {
        Vehiculo seleccionado = listViewVehiculosEncontrados.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listViewVehiculoSeleccionado.getItems().clear();
            listViewVehiculoSeleccionado.getItems().add(seleccionado);
        } else {
            vistas.mostrarError("Lista vacia","Selecciona un vehículo de la lista de la izquierda.");
        }
    }



    @javafx.fxml.FXML
    public void onClickPagar(ActionEvent actionEvent) {
        if(!listViewVehiculoSeleccionado.getItems().isEmpty()){
            Vehiculo vehiculo = listViewVehiculoSeleccionado.getItems().get(0);
            //vehiculo.setDisponible(false); // Ya el vehiculo no estará disponible
            System.out.println("La lista de vehiculos tiene los siguientes datos: " + vehiculo.getDisponible());

            ArrayList <Vehiculo> listaVehiculos = contrato.leerArchivoVehiculos("Data/Vehiculos.txt");
            for (int i = 0; i < listaVehiculos.size(); i++) {
                String placaLista = Arrays.toString(listaVehiculos.get(i).getPlaca());
                String placaSeleccionado = Arrays.toString(vehiculo.getPlaca());

                if (Arrays.equals(listaVehiculos.get(i).getPlaca(), vehiculo.getPlaca())) {
                    vehiculo.setDisponible(false);// cambiar estado
                    listaVehiculos.set(i, vehiculo);// actualizar la lista
                    break;
                }
            }


            if (contrato.sobrescribirVehiculos("Data/Vehiculos.txt", listaVehiculos)){
                contrato.setVehiculo(vehiculo);
                Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                vistas.abrirVentana("/org/puj/proyectorentcar/seleccion-adicional.fxml", "Selección de servicios adicionales", actual, this.contrato);
            }
            else{
                vistas.mostrarError("Error", "No fue posible cambiar la disponibilidad del vehiculo");
            }

        }
        else {
            vistas.mostrarError("Vehiculo no seleccionado", "Debe seleccionar un vehiculo para continuar");
        }
    }



    @Override
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
        ArrayList <Vehiculo> traerVehiculos = contrato.leerArchivoVehiculos("Data/Vehiculos.txt");
        ArrayList <Vehiculo> listaFiltrada = new ArrayList<>();

        for(Vehiculo vh : traerVehiculos){
            if(contrato.getAlquiler().getCiudadOrg().equals(vh.getCiudad())){
                if (contrato.getAlquiler().getPaisOrg().equals(vh.getPaisActual())){
                    if(vh.getDisponible()){
                        listaFiltrada.add(vh);
                    }
                }
            }

        }

        /*if (traerVehiculos != null) {
            listViewVehiculosEncontrados.getItems().addAll(traerVehiculos);
        }*/

        if (listaFiltrada != null){
            listViewVehiculosEncontrados.getItems().addAll(listaFiltrada);
        }
    }


}
