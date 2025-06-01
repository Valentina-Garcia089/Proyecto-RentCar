package org.puj.proyectorentcar.Negocio;


import java.time.LocalDate;


public class Pago {
    private String franquiciaT;
    private long numTarjeta;
    private LocalDate vencimientoT;
    private int cvv;
    private int numeroCuotas;

    public Pago(String franquiciaT, long numTarjeta, LocalDate vencimientoT, int cvv, int numeroCuotas) {
        this.franquiciaT = franquiciaT;
        this.numTarjeta = numTarjeta;
        this.vencimientoT = vencimientoT;
        this.cvv = cvv;
        this.numeroCuotas = numeroCuotas;
    }

    public String getFranquiciaT() {
        return franquiciaT;
    }

    public void setFranquiciaT(String franquiciaT) {
        this.franquiciaT = franquiciaT;
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public LocalDate getVencimientoT() {
        return vencimientoT;
    }

    public void setVencimientoT(LocalDate vencimientoT) {
        this.vencimientoT = vencimientoT;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "franquiciaT='" + franquiciaT + '\'' +
                ", numTarjeta=" + numTarjeta +
                ", vencimientoT=" + vencimientoT +
                ", cvv=" + cvv +
                ", numeroCuotas=" + numeroCuotas +
                '}';
    }
}
