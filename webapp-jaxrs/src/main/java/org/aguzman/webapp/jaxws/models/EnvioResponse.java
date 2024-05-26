package org.aguzman.webapp.jaxws.models;

public class EnvioResponse {
    private double distanciaEnKm;
    private double costoEnvio;
    private double tiempoEnMinutos;

    public EnvioResponse(double distanciaEnKm, double costoEnvio, double tiempoEnMinutos) {
        this.distanciaEnKm = distanciaEnKm;
        this.costoEnvio = costoEnvio;
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    // Getters y Setters
    public double getDistanciaEnKm() {
        return distanciaEnKm;
    }

    public void setDistanciaEnKm(double distanciaEnKm) {
        this.distanciaEnKm = distanciaEnKm;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(double tiempoEnMinutos) {
        this.tiempoEnMinutos = tiempoEnMinutos;
    }
}
