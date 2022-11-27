package com.example.proyectotorettotrucking.clases;

public class Usuario {
    private boolean registrado;
    private String correo, contraseña;
    private int id,role;
    public Usuario() {
    }

    public Usuario(boolean registrado, String correo, String contraseña, int id, int role) {
        this.registrado = registrado;
        this.correo = correo;
        this.contraseña = contraseña;
        this.id = id;
        this.role = role;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
