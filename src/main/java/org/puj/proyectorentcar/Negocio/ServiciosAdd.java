package org.puj.proyectorentcar.Negocio;

public class ServiciosAdd {
    private String tipo;
    private float costo;

    public ServiciosAdd(float costo, String tipo) {
        this.costo = costo;
        this.tipo = tipo;
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
