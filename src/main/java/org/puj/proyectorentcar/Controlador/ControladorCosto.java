package org.puj.proyectorentcar.Controlador;

import org.puj.proyectorentcar.Negocio.Alquiler;

import java.time.LocalDate;
import java.util.List;

public class ControladorCosto {
    private List<Alquiler>  alquilerList;

    public Alquiler buscar(LocalDate entrega, LocalDate devolucion ){
        for(Alquiler e: alquilerList){
            if(e!=null){
                if(e.getFechaEntrega().equals(entrega) && e.getFechaDevolucion().equals(devolucion)){
                    return e;
                }
            }
        }
        return null;
    }

    public void AgregarAlquiler(){

    }




    public ControladorCosto() {
    }
    public void obtenerDatosCalculo(){

    }
    public float calcularTarifaBase(){
        return 0;
    }
    public float calcularCostoServicio(){
        return 0;
    }
    public float calcularCostoSeguro(){
        return 0;
    }
    public float verificarPenalizaciones(){
        return 0;
    }
    public float agregarCostoReparacion(){
        return 0;
    }
    public float calcularCargoCombustible(){
        return 0;
    }
    public float aplicarDescuentoClienteFrecuente(){
        return 0;
    }
    public float calcularMontoReal(){
        return 0;
    }
    public String generarDetalleCalculo(){
        return "" ;
    }
    public void mostrarMensaje(){

    }


}
