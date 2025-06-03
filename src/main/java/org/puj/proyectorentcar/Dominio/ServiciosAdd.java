package org.puj.proyectorentcar.Dominio;

public class ServiciosAdd {
    private String tipo;
    private float costo;


    public ServiciosAdd(String tipo, float costo) {
        this.tipo = tipo;
        this.costo = costo;

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



    @Override
    public String toString() {
        return "ServiciosAdd{" +
                "tipo='" + tipo + '\'' +
                ", costo=" + costo +
                '}';
    }
}
