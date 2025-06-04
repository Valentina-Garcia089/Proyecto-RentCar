package org.puj.proyectorentcar.Util;

import org.puj.proyectorentcar.Dominio.Cliente;
import org.puj.proyectorentcar.Dominio.Arrendatario;
import org.puj.proyectorentcar.Dominio.PlacaException;
import org.puj.proyectorentcar.Dominio.Vehiculo;
import org.puj.proyectorentcar.Negocio.Contrato;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;


public class GestorArchivos {


    // Agregar 1 cliente sin borrar el archivo existente
    public boolean agregarCliente(String nombreArchivo, Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(cliente.exportar());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir cliente en el archivo: " + e.getMessage());
        }
        return false;
    }

    // Agregar 1 arrendatario sin borrar el archivo existente
    public boolean agregarArrendatario(String nombreArchivo, Arrendatario arrendatario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(arrendatario.exportar());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir arrendatario en el archivo: " + e.getMessage());
        }
        return false;
    }

    // Agregar 1 vehículo sin borrar el archivo existente
    public boolean agregarVehiculo(String nombreArchivo, Vehiculo vehiculo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(vehiculo.exportar());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir vehículo en el archivo: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Vehiculo> leerVehiculos(String nombreArchivo) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length == 11) {
                    try {
                        int numSillas = Integer.parseInt(partes[0]);
                        int numPuertas = Integer.parseInt(partes[1]);
                        float capacidadMotor = Float.parseFloat(partes[2]);
                        String color = partes[3];
                        char[] placa = partes[4].toCharArray(); // Aquí podría lanzar PlacaException
                        String marca = partes[5];
                        String modelo = partes[6];
                        float precioDia = Float.parseFloat(partes[7]);
                        String tipoVehiculo = partes[8];
                        String ciudad = partes[9];
                        String paisActual = partes[10];

                        Vehiculo vehiculo = new Vehiculo(
                                numSillas, numPuertas, capacidadMotor, color,
                                placa, marca, modelo, precioDia,
                                tipoVehiculo, ciudad, paisActual
                        );

                        vehiculos.add(vehiculo);
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato numérico en línea: " + linea);
                    } catch (PlacaException e) {
                        System.err.println("Error de placa en línea: " + linea + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Línea con formato incorrecto: " + linea);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer vehículos del archivo: " + e.getMessage());
        }

        return vehiculos;
    }


    //Guardar contratos
    public void guardarContrato(String nombreArchivo, Contrato contrato) {
        Gson gson = new Gson();
        String json = gson.toJson(contrato);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(json);
            writer.newLine(); // para que cada contrato esté en una línea separada
            System.out.println("Contrato guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar contrato: " + e.getMessage());
        }
    }

    public static ArrayList<Contrato> leerContratos(String nombreArchivo) {
        ArrayList<Contrato> contratos = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Contrato contrato = gson.fromJson(linea, Contrato.class);
                contratos.add(contrato);
            }
        } catch (IOException e) {
            System.err.println("Error al leer contratos: " + e.getMessage());
        }

        return contratos;
    }
}
