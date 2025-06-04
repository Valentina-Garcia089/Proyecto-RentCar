package org.puj.proyectorentcar.Negocio;

import org.puj.proyectorentcar.Dominio.*;
import org.puj.proyectorentcar.Util.GestorArchivos;

import java.util.ArrayList;

public class Contrato {
    Cliente cliente;
    Arrendatario arrendatario;
    Vehiculo vehiculo;
    Alquiler alquiler;
    ArrayList <Vehiculo> listaVehiculos = new ArrayList<>();
    ArrayList <Seguro> listaSeguros = new ArrayList<>();
    ArrayList <ServiciosAdd> listaServiciosAdd = new ArrayList<>();
    GestorArchivos archivos = new GestorArchivos();

    public ArrayList<ServiciosAdd> getListaServiciosAdd() {
        return listaServiciosAdd;
    }

    public void setListaServiciosAdd(ArrayList<ServiciosAdd> listaServiciosAdd) {
        this.listaServiciosAdd = listaServiciosAdd;
    }

    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setArrendatario(Arrendatario arrendatario) {
        this.arrendatario = arrendatario;
    }

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

    public boolean guardarClienteArchivo(String nombreArchivo, Cliente cliente){
        if(archivos.agregarCliente(nombreArchivo, cliente)){
            this.cliente = cliente;
            System.out.println("ES VERDADEROOOOOO");
            return true;
        }
        else{
            System.out.println("ES FALSOOOOOOO");
            return false;
        }
    }
    public boolean guardarArrendatarioArchivo(String nombreArchivo, Arrendatario arrendatario){
        if(archivos.agregarArrendatario(nombreArchivo, arrendatario)){
            this.arrendatario = arrendatario;
            System.out.println("ES VERDADEROOOOOO");
            return true;
        }
        else{
            System.out.println("ES FALSOOOOOOO");
            return false;
        }
    }

    public boolean guardarVehiculoArchivo(String nombreArchivo, Vehiculo vehiculo){
        if(archivos.agregarVehiculo(nombreArchivo, vehiculo)){
            this.vehiculo = vehiculo;
            //System.out.println("El valor de vehiculo es: " + getVehiculo());
            return true;
        }
        return false;
    }

    public boolean sobrescribirVehiculos(String nombreArchivo, ArrayList<Vehiculo> listaVehiculos){
        if (archivos.sobrescribirVehiculos(nombreArchivo, listaVehiculos)) {
            this.listaVehiculos = listaVehiculos;
            return true;
        }
        return false;
    }

    public ArrayList <Vehiculo> leerArchivoVehiculos(String nombreArchivo){
        listaVehiculos = archivos.leerVehiculos(nombreArchivo);
        return listaVehiculos;
    }


}
