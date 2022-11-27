package com.example.proyectotorettotrucking.clases;

public class Vehiculo {

    private int id;
    private int[] dimensiones;
    private String matricula, marca;
    private boolean propio;
    private float capacidad;

    public Vehiculo() {
    }

    public Vehiculo(int id, int[] dimensiones, String matricula, String marca, boolean propio, float capacidad) {
        this.id = id;
        this.dimensiones = dimensiones;
        this.matricula = matricula;
        this.marca = marca;
        this.propio = propio;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int[] dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isPropio() {
        return propio;
    }

    public void setPropio(boolean propio) {
        this.propio = propio;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }
}
