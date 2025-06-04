package org.puj.proyectorentcar.Dominio;

public class Seguro {
    private String tipo;
    private float costo;
    private float porcentajeRetencion;

    public Seguro(String tipo, float costo, float porcentajeRetencion) {
        if(tipo.equalsIgnoreCase("Sin seguro")){
            this.tipo = "Sin seguro";
            this.costo = 0;
            this.porcentajeRetencion = 70;
        }else if (tipo.equalsIgnoreCase("Seguro llantas")){
            this.tipo = "Seguro llantas";
            this.costo = 300000;
            this.porcentajeRetencion = 40;
        }else if (tipo.equalsIgnoreCase("Seguro vidiros")){
            this.tipo = "Seguro vidiros";
            this.costo = 100000;
            this.porcentajeRetencion = 20;
        }else if(tipo.equalsIgnoreCase("Todo riesgo")) {
            this.tipo = "Todo riesgo";
            this.costo = 500000;
            this.porcentajeRetencion = 0;
        }
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
