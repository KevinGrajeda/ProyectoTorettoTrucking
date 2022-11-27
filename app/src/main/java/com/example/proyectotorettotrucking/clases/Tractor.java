package com.example.proyectotorettotrucking.clases;

public class Tractor extends Vehiculo{
    private String tipo,longitudCaja, suspension,traccion;
    private int llantas;
    private boolean refrigerado;

    public Tractor(int id, int[] dimensiones, String matricula, String marca, boolean propio, float capacidad, String tipo, String longitudCaja, String suspension, String traccion, int llantas, boolean refrigerado) {
        super(id, dimensiones, matricula, marca, propio, capacidad);
        this.tipo = tipo;
        this.longitudCaja = longitudCaja;
        this.suspension = suspension;
        this.traccion = traccion;
        this.llantas = llantas;
        this.refrigerado = refrigerado;
    }

    public Tractor() {
        super();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLongitudCaja() {
        return longitudCaja;
    }

    public void setLongitudCaja(String longitudCaja) {
        this.longitudCaja = longitudCaja;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public int getLlantas() {
        return llantas;
    }

    public void setLlantas(int llantas) {
        this.llantas = llantas;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }
}
