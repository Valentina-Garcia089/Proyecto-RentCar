package org.puj.proyectorentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.puj.proyectorentcar.Negocio.Usuario;
import org.puj.proyectorentcar.Pantalla.GestorVistas;

public class HelloController {

    // Creación de objeto
    GestorVistas ventanas = new GestorVistas();
    @FXML
    private TextField txtNombreIngresar;
    @FXML
    private ChoiceBox <String> choiceTipoId;
    @FXML
    private TextField txtEdadIngresar;
    @FXML
    private TextField txtApellidoIngresar;
    @FXML
    private TextField txtNumeroId;
    @FXML
    private TextField txtCorreoIngresar;
    @FXML
    private TextField txtDireccionIngresar;
    @FXML
    private TextField txtTelefonoIngresar;
    @FXML
    private PasswordField txtContrasena;


    @FXML
    public void initialize(){
        choiceTipoId.getItems().addAll("Cliente", "Arrendatario");
    }
    @FXML
    public void onClickRegistrarse(ActionEvent actionEvent) {
        String usr = txtNombreIngresar.getText();
        String apellido = txtApellidoIngresar.getText();
        int edad = Integer.parseInt(txtEdadIngresar.getText());
        long numId = Long.parseLong(txtNumeroId.getText());
        String tipoSeleccionado = choiceTipoId.getValue();
        String email = txtCorreoIngresar.getText();
        String direccion = txtDireccionIngresar.getText();
        long tel = Long.parseLong(txtTelefonoIngresar.getText());
        String pwd = txtContrasena.getText();

        Usuario user = new Usuario(usr, apellido, edad, direccion, tel, email, tipoSeleccionado, numId, pwd);

        Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ventanas.abrirVentana("/org/puj/proyectorentcar/RegistroParteDos.fxml", "Registro", actual);
    }
}