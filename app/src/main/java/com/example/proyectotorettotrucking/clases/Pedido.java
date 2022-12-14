package com.example.proyectotorettotrucking.clases;

import java.io.Serializable;

public class Pedido implements Serializable {

    private int id,noPedido,destino,origen,vehiculo,status;
    private String descripcion,productos;
    private float precio;

    public Pedido() {
    }

    public Pedido(int id, int destino, int origen, String productos, int vehiculo, int status, String descripcion, float precio) {
        this.id = id;
        this.destino = destino;
        this.origen = origen;
        this.productos = productos;
        this.vehiculo = vehiculo;
        this.status = status;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(int noPedido) {
        this.noPedido = noPedido;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
