package org.puj.proyectorentcar.Dominio;

public class Cliente extends Usuario{
    public Cliente(String nombre, String apellido, int edad, String direccion, long telefono, String correo, String tipoId, long numeroId, String tipoUsuario, String contrasenia) {
        super(nombre, apellido, edad, direccion, telefono, correo, tipoId, numeroId, tipoUsuario, contrasenia);
    }
}
