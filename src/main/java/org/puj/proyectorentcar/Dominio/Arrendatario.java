package org.puj.proyectorentcar.Dominio;

import java.util.ArrayList;

public class Arrendatario extends Usuario{
    ArrayList<Vehiculo> vehiculosArrendatario = new ArrayList<>();

    public Arrendatario(String nombre, String apellido, int edad, String direccion, long telefono, String correo, String tipoId, long numeroId, String tipoUsuario,String contrasenia) {
        super(nombre, apellido, edad, direccion, telefono, correo, tipoId, numeroId, tipoUsuario, contrasenia);
    }
}
