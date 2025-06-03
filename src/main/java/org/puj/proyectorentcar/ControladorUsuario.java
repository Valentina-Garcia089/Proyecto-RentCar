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
    GestorVistas vistas = new GestorVistas();
    Usuario user;

    @FXML
    public void initialize(){

        try {
            choiceTipoId.getItems().addAll("CC", "CE", "Pasaporte");
            choiceTipoUsuario.getItems().addAll("Cliente", "Arrendatario");
        } catch (Exception e) {
            vistas.mostrarError("Error al inicializar componentes", e.getMessage());
        }
    }


    @FXML
    public void onClickRegistrarse(ActionEvent actionEvent) {
        try {
            // Validar campos
            if (!validarCampos()) {
                return;
            }

            // Obtener datos con manejo de excepciones
            String usr = txtNombreIngresar.getText();
            String apellido = txtApellidoIngresar.getText();
            String direccion = txtDireccionIngresar.getText();
            String email = txtCorreoIngresar.getText();
            String tipoID = choiceTipoId.getValue();
            String tipoUsuario = choiceTipoUsuario.getValue();
            String pwd = txtContrasena.getText();

            // Conversiones con manejo de errores
            int edad;
            long tel;
            long numId;

            try {
                edad = Integer.parseInt(txtEdadIngresar.getText().trim());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en edad", "La edad debe ser un número válido");
                return;
            }

            try {
                tel = Long.parseLong(txtTelefonoIngresar.getText().trim());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en teléfono", "El teléfono debe ser solo números");
                return;
            }

            try {
                numId = Long.parseLong(txtNumeroId.getText().trim());
            } catch (NumberFormatException e) {
                vistas.mostrarError("Error en número de ID", "El número de ID debe ser solo números");
                return;
            }

            if (edad < 18) {
                vistas.mostrarError("Error de edad", "Debe ser mayor de 18 años");
                return;
            }

            // Ventana actual
            Stage actual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Crear usuario según el tipo
            if ("Cliente".equals(tipoUsuario)) {
                user = new Cliente(usr, apellido, edad, direccion, tel, email, tipoID, numId, tipoUsuario, pwd);
                vistas.abrirVentana("/org/puj/proyectorentcar/cliente-vista.fxml", "Alquiler de vehiculo", actual);
            }
            else if ("Arrendatario".equals(tipoUsuario)){
                user = new Arrendatario(usr, apellido, edad, direccion, tel, email, tipoID, numId, tipoUsuario, pwd);
                vistas.abrirVentana("/org/puj/proyectorentcar/registrar-vehiculo.fxml", "Registro Vehiculo", actual);
            }

        } catch (Exception e) {
            // Captura cualquier otra excepción
            vistas.mostrarError("Error inesperado", "Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private boolean validarCampos() {
        StringBuilder errores = new StringBuilder();

        if (txtNombreIngresar.getText().trim().isEmpty()) {
            errores.append(" El nombre es requerido\n");
        }

        if (txtApellidoIngresar.getText().trim().isEmpty()) {
            errores.append(" El apellido es requerido\n");
        }

        if (txtEdadIngresar.getText().trim().isEmpty()) {
            errores.append(" La edad es requerida\n");
        }

        if (txtDireccionIngresar.getText().trim().isEmpty()) {
            errores.append(" La dirección es requerida\n");
        }

        if (txtTelefonoIngresar.getText().trim().isEmpty()) {
            errores.append(" El teléfono es requerido\n");
        }

        if (txtCorreoIngresar.getText().trim().isEmpty()) {
            errores.append(" El correo es requerido\n");
        }

        if (txtNumeroId.getText().trim().isEmpty()) {
            errores.append(" El número de ID es requerido\n");
        }

        if (txtContrasena.getText().isEmpty()) {
            errores.append(" La contraseña es requerida\n");
        }

        if (choiceTipoId.getValue() == null) {
            errores.append(" Debe seleccionar un tipo de ID\n");
        }

        if (choiceTipoUsuario.getValue() == null) {
            errores.append(" Debe seleccionar un tipo de usuario\n");
        }

        // Validar formato de email
        if (!txtCorreoIngresar.getText().trim().isEmpty() &&
                !txtCorreoIngresar.getText().contains("@")) {
            errores.append("- El formato del correo no es válido\n");
        }

        if (errores.length() > 0) {
            vistas.mostrarError("Campos requeridos", errores.toString());
            return false;
        }

        return true;
    }
}

