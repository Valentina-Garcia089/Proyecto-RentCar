package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Dominio.Arrendatario;
import org.puj.proyectorentcar.Dominio.Cliente;
import org.puj.proyectorentcar.Dominio.Usuario;
import org.puj.proyectorentcar.Negocio.GestorVistas;

public class ControladorUsuario {
    @FXML
    private TextField txtNumeroId;
    @FXML
    private TextField txtDireccionIngresar;
    @FXML
    private TextField txtNombreIngresar;
    @FXML
    private TextField txtCorreoIngresar;
    @FXML
    private ChoiceBox <String> choiceTipoId;
    @FXML
    private ChoiceBox <String> choiceTipoUsuario;
    @FXML
    private TextField txtTelefonoIngresar;
    @FXML
    private TextField txtEdadIngresar;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private TextField txtApellidoIngresar;
    @FXML
    private Button btnRegistrarse;


    // Creación de objeto
    GestorVistas ventanas = new GestorVistas();
    Usuario user;

    @FXML
    public void initialize(){
        choiceTipoId.getItems().addAll("CC", "TI", "CE", "Pasaporte");
        choiceTipoUsuario.getItems().addAll("Cliente", "Arrendatario");
    }

    @FXML
    public void onClickRegistrarse(ActionEvent actionEvent) {
        String usr = txtNombreIngresar.getText();
        String apellido = txtApellidoIngresar.getText();
        int edad = Integer.parseInt(txtEdadIngresar.getText());
        String direccion = txtDireccionIngresar.getText();
        long tel = Long.parseLong(txtTelefonoIngresar.getText());
        String email = txtCorreoIngresar.getText();
        String tipoID = choiceTipoId.getValue();
        long numId = Long.parseLong(txtNumeroId.getText());
        String tipoUsuario = choiceTipoUsuario.getValue();
        String pwd = txtContrasena.getText();

        // Ventana actual
        Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        if ("Cliente".equals(tipoUsuario)) {
            user = new Cliente(usr, apellido, edad, direccion, tel, email, tipoID, numId, tipoUsuario, pwd);
            ventanas.abrirVentana("/org/puj/proyectorentcar/<>.fxml", "Alquiler de vehiculo", actual);
        }
        else if ("Arrendatario".equals(tipoUsuario)){
            user = new Arrendatario(usr, apellido, edad, direccion, tel, email, tipoID, numId, tipoUsuario, pwd);
            ventanas.abrirVentana("/org/puj/proyectorentcar/registrar-vehiculo.fxml", "Registro Vehiculo", actual);
        }

    }

}