package com.example.pedidopizzeria;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombreUsuario;
    private int telefono;
    private String recogida;
    private String direccion;

    public Usuario(String nombreUsuario, int telefono, String direccion, String recogida) {
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.recogida = recogida;

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", telefono=" + telefono +
                ", recogida='" + recogida + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRecogida() {
        return recogida;
    }

    public void setRecogida(String recogida) {
        this.recogida = recogida;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
