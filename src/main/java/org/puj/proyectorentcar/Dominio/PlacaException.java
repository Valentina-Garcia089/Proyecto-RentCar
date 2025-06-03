package org.puj.proyectorentcar.Dominio;


public class PlacaException extends Exception {
    public PlacaException(String mensaje) {
        super(mensaje);
    }

    public PlacaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}