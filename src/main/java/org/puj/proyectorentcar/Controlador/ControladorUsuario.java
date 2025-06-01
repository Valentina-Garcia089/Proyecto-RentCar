package org.puj.proyectorentcar.Controlador;
import org.puj.proyectorentcar.Negocio.Cliente;
import org.puj.proyectorentcar.Negocio.Arrendatario;
import org.puj.proyectorentcar.Negocio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private List<org.puj.proyectorentcar.Negocio.Usuario> usuarios;

    public ControladorUsuario() {
        usuarios = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        usuarios.add(cliente);
        // Guardar en archivo
    }

    public void registrarArrendatario(Arrendatario arr) {
        usuarios.add(arr);
        // Guardar en archivo
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
