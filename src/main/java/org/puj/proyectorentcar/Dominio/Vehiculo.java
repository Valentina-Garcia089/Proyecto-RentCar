package org.puj.proyectorentcar.Dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Vehiculo {

    private static List<String> placasRegistradas = new ArrayList<>();
    private static List<Vehiculo> vehiculosRegistrados = new ArrayList<>();
    private static final String ARCHIVO_VEHICULOS = "vehiculos.txt";


        private int numSillas;
        private int numPuertas;
        private float capacidadMotor;
        private String color;
        private char[] placa;
        private String marca;
        private String modelo;
        private float precioDia;
        private String tipoVehiculo;
        private String ciudad;
        private String paisActual;



    public String exportar() {
        return numSillas + "," +
                numPuertas + "," +
                capacidadMotor + "," +
                color + "," +
                String.valueOf(placa) + "," +
                marca + "," +
                modelo + "," +
                precioDia + "," +
                tipoVehiculo + "," +
                ciudad + "," +
                paisActual;
    }




    public Vehiculo(int numSillas, int numPuertas, float capacidadMotor, String color, char[] placa, String marca, String modelo, float precioDia,
                    String tipoVehiculo, String ciudad, String paisActual)  throws PlacaException {
        this.numSillas = numSillas;
        this.numPuertas = numPuertas;
        this.capacidadMotor = capacidadMotor;
        this.color = color;
        this.placa = placa;

        String Placaa = new String(placa);
        if (placasRegistradas.contains(Placaa)) {
            throw new PlacaException("La placa " + Placaa + " ya está registrada en el sistema");
        }

        setPlaca(placa);
        this.marca = marca;
        this.modelo = modelo;
        this.precioDia = precioDia;
        this.tipoVehiculo = tipoVehiculo;
        this.ciudad = ciudad;
        this.paisActual = paisActual;

        placasRegistradas.add(new String(this.placa));
        vehiculosRegistrados.add(this);
    }

    // Constructor para cargar desde archivo (sin validación de placa duplicada)
    private Vehiculo(int numSillas, int numPuertas, float capacidadMotor, String color,
                     char[] placa, String marca, String modelo, float precioDia,
                     String tipoVehiculo, String ciudad, String paisActual, boolean fromFile) {
        this.numSillas = numSillas;
        this.numPuertas = numPuertas;
        this.capacidadMotor = capacidadMotor;
        this.color = color;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precioDia = precioDia;
        this.tipoVehiculo = tipoVehiculo;
        this.ciudad = ciudad;
        this.paisActual = paisActual;
    }

    // Metodo para cargar vehículos al iniciar el programa
    public static void cargarVehiculos() {
        File archivo = new File(ARCHIVO_VEHICULOS);
        if (!archivo.exists()) {
            System.out.println("No se encontró archivo de vehículos. Iniciando con lista vacía.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            vehiculosRegistrados.clear();
            placasRegistradas.clear();

            while ((linea = reader.readLine()) != null) {
                Vehiculo vehiculo = parsearLineaVehiculo(linea);
                if (vehiculo != null) {
                    vehiculosRegistrados.add(vehiculo);
                    placasRegistradas.add(new String(vehiculo.placa));
                }
            }
            System.out.println("Se cargaron " + vehiculosRegistrados.size() + " vehículos desde el archivo.");
        } catch (IOException e) {
            System.err.println("Error al cargar vehículos: " + e.getMessage());
        }
    }

    // Metodo para guardar vehículos al cerrar el programa
    public static void guardarVehiculos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_VEHICULOS))) {
            for (Vehiculo vehiculo : vehiculosRegistrados) {
                writer.println(vehiculo.toFileString());
            }
            System.out.println("Se guardaron " + vehiculosRegistrados.size() + " vehículos en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al guardar vehículos: " + e.getMessage());
        }
    }

    // Convertir vehículo a string para archivo (separado por |)
    private String toFileString() {
        return numSillas + "|" + numPuertas + "|" + capacidadMotor + "|" + color + "|" +
                new String(placa) + "|" + marca + "|" + modelo + "|" + precioDia + "|" +
                tipoVehiculo + "|" + ciudad + "|" + paisActual;
    }

    // Parsear línea del archivo para crear vehículo
    private static Vehiculo parsearLineaVehiculo(String linea) {
        try {
            String[] datos = linea.split("\\|");
            if (datos.length != 11) {
                System.err.println("Línea con formato incorrecto: " + linea);
                return null;
            }

            int numSillas = Integer.parseInt(datos[0]);
            int numPuertas = Integer.parseInt(datos[1]);
            float capacidadMotor = Float.parseFloat(datos[2]);
            String color = datos[3];
            char[] placa = datos[4].toCharArray();
            String marca = datos[5];
            String modelo = datos[6];
            float precioDia = Float.parseFloat(datos[7]);
            String tipoVehiculo = datos[8];
            String ciudad = datos[9];
            String paisActual = datos[10];

            return new Vehiculo(numSillas, numPuertas, capacidadMotor, color, placa,
                    marca, modelo, precioDia, tipoVehiculo, ciudad, paisActual, true);
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear datos numéricos en línea: " + linea);
            return null;
        }
    }

    public boolean verificarPlacaExistente() {

        if (this.placa == null) {
            return false;
        }
        String Placaa = new String(this.placa);
        for (String placaRegistrada : placasRegistradas) {
            if (placaRegistrada.equals(Placaa)) {
                return true;
            }
        }
        return false;
    }

    public void crearVehiculo() {
        System.out.println("Vehículo agregado al sistemaaa: " + marca + " " + modelo + " con placa " + new String(placa));
    }

    public Vehiculo getVehiculo() {
        return this;
    }

    public int getNumSillas() { return numSillas; }
    public void setNumSillas(int numSillas) { this.numSillas = numSillas; }

    public int getNumPuertas() { return numPuertas; }
    public void setNumPuertas(int numPuertas) { this.numPuertas = numPuertas; }

    public float getCapacidadMotor() { return capacidadMotor; }
    public void setCapacidadMotor(float capacidadMotor) { this.capacidadMotor = capacidadMotor; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }



    public char[] getPlaca() { return placa; }
    public void setPlaca(char[] placa) throws PlacaException {

        if (placa.length != 6) {
            throw new PlacaException("La placa solo pueden ser 3 numero y 3 letras");
        }
        this.placa = new char[6];
        System.arraycopy(placa, 0, this.placa, 0, 6);
    }



    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public float getPrecioDia() { return precioDia; }
    public void setPrecioDia(float precioDia) { this.precioDia = precioDia; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getPaisActual() { return paisActual; }
    public void setPaisActual(String paisActual) { this.paisActual = paisActual; }
}

