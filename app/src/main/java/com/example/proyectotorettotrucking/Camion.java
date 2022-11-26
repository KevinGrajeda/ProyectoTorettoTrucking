package com.example.proyectotorettotrucking;

public class Camion extends  Vehiculo{
    String tipo;
    boolean cerrado;

    public Camion() {
        super();
    }

    public Camion(int id, int[] dimensiones, String matricula, String marca, boolean propio, float capacidad, String tipo, boolean cerrado) {
        super(id, dimensiones, matricula, marca, propio, capacidad);
        this.tipo = tipo;
        this.cerrado = cerrado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }
}
