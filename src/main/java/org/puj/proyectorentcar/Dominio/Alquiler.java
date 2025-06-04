package org.puj.proyectorentcar.Dominio;

import java.time.LocalDate;
import java.util.List;

public class Alquiler {
    private String ciudadOrg;
    private String paisOrg;
    private String paisDst;
    private String ciudadDst;
    private String oficinaRecogida;
    private String oficinaDevolucion;
    private LocalDate fechaEntrega;
    private LocalDate fechaDevolucion;
    private List<Pago> pago;
    private List<Seguro> seguro;
    private List<ServiciosAdd> serviciosAdds;

    public Alquiler(String ciudadOrg, String paisOrg, String paisDst, String oficinaRecogida, String ciudadDst, String oficinaDevolucion, LocalDate fechaEntrega, LocalDate fechaDevolucion) {
        this.ciudadOrg = ciudadOrg;
        this.paisOrg = paisOrg;
        this.paisDst = paisDst;
        this.oficinaRecogida = oficinaRecogida;
        this.ciudadDst = ciudadDst;
        this.oficinaDevolucion = oficinaDevolucion;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getCiudadOrg() {
        return ciudadOrg;
    }

    public void setCiudadOrg(String ciudadOrg) {
        this.ciudadOrg = ciudadOrg;
    }

    public String getPaisOrg() {
        return paisOrg;
    }

    public void setPaisOrg(String paisOrg) {
        this.paisOrg = paisOrg;
    }

    public String getPaisDst() {
        return paisDst;
    }

    public void setPaisDst(String paisDst) {
        this.paisDst = paisDst;
    }

    public String getCiudadDst() {
        return ciudadDst;
    }

    public void setCiudadDst(String ciudadDst) {
        this.ciudadDst = ciudadDst;
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

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    public List<Seguro> getSeguro() {
        return seguro;
    }

    public void setSeguro(List<Seguro> seguro) {
        this.seguro = seguro;
    }

    public List<ServiciosAdd> getServiciosAdds() {
        return serviciosAdds;
    }

    public void setServiciosAdds(List<ServiciosAdd> serviciosAdds) {
        this.serviciosAdds = serviciosAdds;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "ciudadOrg='" + ciudadOrg + '\'' +
                ", paisOrg='" + paisOrg + '\'' +
                ", paisDst='" + paisDst + '\'' +
                ", ciudadDst='" + ciudadDst + '\'' +
                ", oficinaRecogida='" + oficinaRecogida + '\'' +
                ", oficinaDevolucion='" + oficinaDevolucion + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                ", fechaDevolucion=" + fechaDevolucion +
                ", pago=" + pago +
                ", seguro=" + seguro +
                ", serviciosAdds=" + serviciosAdds +
                '}';
    }

    public void AgregarPago(String franquiciaT, long numeroTarjeta, String nombreT,LocalDate vencimientoT,int cvv, int numeroCuotas ){

            Pago e=new Pago(franquiciaT,numeroTarjeta,nombreT,vencimientoT,cvv,numeroCuotas);
            this.pago.add(e);

    }
    public void AgregarSeguro(String tipo,float costo,float porcentageRetencion){
        if(seguro.size()<4){
            Seguro e=new Seguro(tipo);
            this.seguro.add(e);
        }
    }
    public void AgregarServicio(String tipo){
        if(serviciosAdds.size()<4){
            ServiciosAdd e=new ServiciosAdd(tipo);
            this.serviciosAdds.add(e);
        }
    }


}
