package org.puj.proyectorentcar.Negocio;

import org.puj.proyectorentcar.Dominio.Alquiler;
import org.puj.proyectorentcar.Dominio.Arrendatario;
import org.puj.proyectorentcar.Dominio.Cliente;
import org.puj.proyectorentcar.Dominio.Vehiculo;

public class Contrato {
    Cliente cliente;
    Arrendatario arrendatario;
    Vehiculo vehiculo;
    Alquiler alquiler;

    public Cliente getCliente(){
        return cliente;
    }

    public Arrendatario getArrendatario(){
        return arrendatario;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public Alquiler getAlquiler(){
        return alquiler;
    }


}
