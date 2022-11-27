package com.example.proyectotorettotrucking.clases;

public class Pedido {

    private int id,noPedido,destino,origen,productos,vehiculo,status;
    private String descripcion;
    private float precio;

    public Pedido() {
    }

    public Pedido(int id, int noPedido, int destino, int origen, int productos, int vehiculo, int status, String descripcion, float precio) {
        this.id = id;
        this.noPedido = noPedido;
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

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
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
