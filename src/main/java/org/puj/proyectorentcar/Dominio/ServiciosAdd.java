package org.puj.proyectorentcar.Dominio;

public class ServiciosAdd {

    private float costo;
    private String tipo;

    public ServiciosAdd(float costo, String tipo) {
        this.costo = costo;
        if(tipo.equalsIgnoreCase("Conductor adicional")){
            this.tipo = "Conductor adicional";
        }else if (tipo.equalsIgnoreCase("Silla bebe")){
            this.tipo = "Silla bebe";
        }else if (tipo.equalsIgnoreCase("Maletero")){
            this.tipo = "Maletero";
        }else if(tipo.equalsIgnoreCase("GPS")) {
            this.tipo = "GPS";
        }
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ServiciosAdd{" +
                "costo=" + costo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}