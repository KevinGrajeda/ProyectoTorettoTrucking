package com.example.proyectotorettotrucking;

public class Usuario {
    boolean registrado;
    String correo, contraseña;
    public Usuario() {
    }
    //getters
    public boolean isRegistrado() {
        return registrado;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
    //setters
    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
