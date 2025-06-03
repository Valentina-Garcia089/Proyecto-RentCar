package org.puj.proyectorentcar.Dominio;

import java.util.ArrayList;
import java.util.List;

public class ServiciosAdd {

    private String tipo;
    private float costo;

        public static final String CONDUCTOR_ADICIONAL = "Conductor adicional";
        public static final String SILLA_BEBE = "Silla bebé";
        public static final String MALETERO = "Maletero";
        public static final String DISPOSITIVO_GPS = " GPS";

        // Constructores
        public ServiciosAdd() {
        }

        public ServiciosAdd(String tipo, float costo) {
            this.tipo = tipo;
        this.costo = costo;
        }

        public void agregarServicios(){

            System.out.println("Servicios disponibles:");
            System.out.println("- " + CONDUCTOR_ADICIONAL + ": $50,000 al día");
            System.out.println("- " + SILLA_BEBE + ": $100,000 al día");
            System.out.println("- " + MALETERO + ": $80,000 al día");
            System.out.println("- " + DISPOSITIVO_GPS + ": $30,000 al día");
        }

        private static float obtenerCostoServicioPorTipo(String tipoServicio) {
            switch (tipoServicio) {
                case CONDUCTOR_ADICIONAL:
                    return 50000f;
                case SILLA_BEBE:
                    return 100000f;
                case MALETERO:
                    return 80000f;
                case DISPOSITIVO_GPS:
                    return 30000f;
                default:
                    return 0f;
            }
        }
//este es para validar el string
        public static boolean esServicioValido(String tipoServicio) {
                    return tipoServicio.equals(CONDUCTOR_ADICIONAL) ||
                            tipoServicio.equals(SILLA_BEBE) ||
                            tipoServicio.equals(MALETERO) ||
                            tipoServicio.equals(DISPOSITIVO_GPS);
        }

        public float calcularCostoPorDias(int dias) {
            return this.costo * dias;
        }

    //getters y setters
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


}