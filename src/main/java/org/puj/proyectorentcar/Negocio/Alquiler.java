package org.puj.proyectorentcar.Negocio;

import java.time.LocalDate;
import java.util.List;

public class Alquiler {
    private String ciudadOrgen;
    private String paisOrigen;
    private String paisDestino;
    private String ciudadDestino;
    private String oficinaRecogida;
    private String oficinaDevolucion;
    private LocalDate fechaEntrega;
    private LocalDate fechaDevolucion;
    private Pago pago;
    private Seguro seguro;
    private List<ServiciosAdd> serviciosAddList;
    private Contrato contrato;

    public Alquiler(String ciudadOrgen, String paisOrigen, String paisDestino, String ciudadDestino, String oficinaRecogida, String oficinaDevolucion, LocalDate fechaEntrega, LocalDate fechaDevolucion) {
        this.ciudadOrgen = ciudadOrgen;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.ciudadDestino = ciudadDestino;
        this.oficinaRecogida = oficinaRecogida;
        this.oficinaDevolucion = oficinaDevolucion;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getCiudadOrgen() {
        return ciudadOrgen;
    }

    public void setCiudadOrgen(String ciudadOrgen) {
        this.ciudadOrgen = ciudadOrgen;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getOficinaRecogida() {
        return oficinaRecogida;
    }

    public void setOficinaRecogida(String oficinaRecogida) {
        this.oficinaRecogida = oficinaRecogida;
    }

    public String getOficinaDevolucion() {
        return oficinaDevolucion;
    }

    public void setOficinaDevolucion(String oficinaDevolucion) {
        this.oficinaDevolucion = oficinaDevolucion;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "ciudadOrgen='" + ciudadOrgen + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", paisDestino='" + paisDestino + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", oficinaRecogida='" + oficinaRecogida + '\'' +
                ", oficinaDevolucion='" + oficinaDevolucion + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }

    public void agregarPago(String franquiciaT,long numTarjeta,String nombreT, LocalDate vencimientoT,int cvv,int numCuotas) {
        this.pago=new Pago(franquiciaT,numTarjeta,nombreT,vencimientoT,cvv,numCuotas);
    }

    public void agregarSeguro(String tipo,float costo, float procentajeRecpecion){
        this.seguro=new Seguro(tipo,costo,procentajeRecpecion);
    }

    public void AgregarServiciosAdicionales(String tipo, float costo){
        if(serviciosAddList.size()<4){
            ServiciosAdd e=new ServiciosAdd(costo,tipo);
            serviciosAddList.add(e);
        }
    }

    public void AgregarContrato(Contrato contrato){
        this.contrato=contrato;
    }



}
