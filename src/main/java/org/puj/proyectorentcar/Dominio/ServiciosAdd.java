package org.puj.proyectorentcar.Dominio;

public class ServiciosAdd {

    private float costo;
    private String tipo;

    public ServiciosAdd(String tipo) {
        this.costo = costo;
        if(tipo.equalsIgnoreCase("Conductor adicional")){
            this.tipo = "Conductor adicional";
            this.costo = 50000;
        }else if (tipo.equalsIgnoreCase("Silla bebe")){
            this.tipo = "Silla bebe";
            this.costo = 100000;
        }else if (tipo.equalsIgnoreCase("Maletero")){
            this.tipo = "Maletero";
            this.costo = 80000;
        }else if(tipo.equalsIgnoreCase("GPS")) {
            this.tipo = "GPS";
            this.costo = 30000;
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