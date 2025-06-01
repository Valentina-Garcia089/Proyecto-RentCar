package org.puj.proyectorentcar.Negocio;

public class Cliente extends Usuario{
    public Cliente(String nombre, String apellido, int edad, String direccion, long telefono, String correo, String tipoId, long numeroId, String contrasenia) {
        super(nombre, apellido, edad, direccion, telefono, correo, tipoId, numeroId, contrasenia);
    }
}
