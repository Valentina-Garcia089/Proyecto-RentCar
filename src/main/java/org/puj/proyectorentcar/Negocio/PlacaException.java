package org.puj.proyectorentcar.Negocio;


public class PlacaException extends Exception {
    public PlacaException(String mensaje) {
        super(mensaje);
    }

    public PlacaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}