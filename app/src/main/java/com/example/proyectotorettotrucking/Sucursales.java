package com.example.proyectotorettotrucking;

public class Sucursales {
    int id;
    String nombre, estado,ciudad,pais;

    public Sucursales(int id, String nombre, String estado, String ciudad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Sucursales() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
