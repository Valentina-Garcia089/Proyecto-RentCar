package org.puj.proyectorentcar.Controlador;
import org.puj.proyectorentcar.Negocio.Vehiculo;
import org.puj.proyectorentcar.Negocio.PlacaException;

import java.util.ArrayList;
import java.util.List;

public class ControladorVehiculo {
    private List<Vehiculo> vehiculos;

    public ControladorVehiculo() {
        this.vehiculos = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {

        try {
            vehiculos.add(vehiculo);
            System.out.println("Vehículo registrado exitosamente en el controlador");
        } catch (Exception e) {
            mostrarError();
            System.out.println("Error al registrar vehículo: " + e.getMessage());
        }
    }

    public void mostrarMensaje() {

        System.out.println("  Controlador de vehiculos  ");

        System.out.println("Total de vehículos : " + vehiculos.size());

        if (!vehiculos.isEmpty()) {
            System.out.println("\nVehículos en el sistema:");
        } else {
            System.out.println("No hay vehículos ");
        }
    }

    public void mostrarError() {
        System.out.println("HA OCURRIDO UN ERRORrrrrrrrrRrrrRRRRRR ");
    }


    public Vehiculo consultarVehiculo(char[] placa) {

        String placaBuscada = new String(placa);

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca() != null) {
                String placaVehiculo = new String(vehiculo.getPlaca());
                if (placaVehiculo.equals(placaBuscada)) {
                    return vehiculo;
                }
            }
        }
    return null;
    }

}
