package org.puj.proyectorentcar.Dominio;

public class ServiciosAdd {

    private float costo;

    private String conductorAdicional = "Conductor adicional";
    private String sillaBebe = "Silla bebé";
    private String maletero = "Maletero";
    private String dispositivoGps = "GPS";



    public float obtenerCostoServicioPorTipo(String tipoServicio) {
        switch (tipoServicio) {
            case conductorAdicional:
                return 50000f;
            case sillaBebe:
                return 100000f;
            case maletero:
                return 80000f;
            case dispositivoGps:
                return 30000f;
            default:
                return 0f;
        }
    }

    public float calcularCostoPorDias(int dias) {
        return this.costo * dias;
    }


    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }


}