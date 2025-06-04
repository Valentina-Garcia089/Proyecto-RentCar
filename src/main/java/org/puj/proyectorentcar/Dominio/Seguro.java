package org.puj.proyectorentcar.Dominio;

public class Seguro {
    private String tipo;
    private float costo;
    private float porcentajeRetencion;

    public Seguro(String tipo, float costo, float porcentajeRetencion) {
        this.tipo = tipo;
        this.costo = costo;
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public void setPorcentajeRetencion(float porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    @Override
    public String  toString() {
        return "Seguro{" +
                "tipo='" + tipo + '\'' +
                ", costo=" + costo +
                ", porcentajeRetencion=" + porcentajeRetencion +
                '}';
    }
}
