package org.puj.proyectorentcar.Dominio;


import java.util.ArrayList;
import java.util.List;


public class Vehiculo {

    private static List<String> placasRegistradas = new ArrayList<>();
    private static List<Vehiculo> vehiculosRegistrados = new ArrayList<>();

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

        // Validar formato: 3 números seguidos de 3 letras
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(placa[i])) {
                throw new PlacaException("Los primeros 3 caracteres deben ser números");
            }
        }
        for (int i = 3; i < 6; i++) {
            if (!Character.isLetter(placa[i])) {
                throw new PlacaException("Los últimos 3 caracteres deben ser letras");
            }
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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", placa=" + new String(placa) + ", color='" + color + '\'' + ", precioDia=" + precioDia +
                ", tipoVehiculo='" + tipoVehiculo + '\'' + ", ciudad='" + ciudad + '\'' + '}';
    }
}

