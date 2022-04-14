package com.example.pedidopizzeria;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {

    private String nombreUsuario;
    private int telefono;
    private String recogida;
    private String direccion;

    private String tipoPizza;
    private int cantidadPizza;
    private Double precioPizza;

    private String tipoBebida;
    private int cantidadBebida;
    private Double precioBebida;

    public Pedido() {
        this.nombreUsuario = "Miguel";
        this.telefono = 666666666;
    }

    public Pedido(Usuario u, List<Item> i) {


    }

    public Pedido(Usuario u, Item i) {

    }

    public Pedido(Item i) {

    }

    public Pedido(String nombreUsuario, int telefono, String recogida, String direccion, String tipoPizza, int cantidadPizza, Double precioPizza, String tipoBebida, int cantidadBebida, Double precioBebida) {
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.recogida = recogida;
        this.direccion = direccion;
        this.tipoPizza = tipoPizza;
        this.cantidadPizza = cantidadPizza;
        this.precioPizza = precioPizza;
        this.tipoBebida = tipoBebida;
        this.cantidadBebida = cantidadBebida;
        this.precioBebida = precioBebida;
    }

    public Pedido(String nombreUsuario, int telefono, String recogida, String direccion) {
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.recogida = recogida;
        this.direccion = direccion;
    }

    public Pedido(String tipoPizza, int cantidadPizza, Double precioPizza, String tipoBebida, int cantidadBebida, Double precioBebida) {
        this.tipoPizza = tipoPizza;
        this.cantidadPizza = cantidadPizza;
        this.precioPizza = precioPizza;
        this.tipoBebida = tipoBebida;
        this.cantidadBebida = cantidadBebida;
        this.precioBebida = precioBebida;
    }

    public Pedido(String tipoPizza, int cantidadPizza, Double precioPizza) {
        this.tipoPizza = tipoPizza;
        this.cantidadPizza = cantidadPizza;
        this.precioPizza = precioPizza;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", recogida='" + recogida + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoPizza='" + tipoPizza + '\'' +
                ", cantidadPizza=" + cantidadPizza +
                ", precioPizza=" + precioPizza +
                ", tipoBebida='" + tipoBebida + '\'' +
                ", cantidadBebida=" + cantidadBebida +
                ", precioBebida=" + precioBebida +
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

    public String getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(String tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public int getCantidadPizza() {
        return cantidadPizza;
    }

    public void setCantidadPizza(int cantidadPizza) {
        this.cantidadPizza = cantidadPizza;
    }

    public Double getPrecioPizza() {
        return precioPizza;
    }

    public void setPrecioPizza(Double precioPizza) {
        this.precioPizza = precioPizza;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public int getCantidadBebida() {
        return cantidadBebida;
    }

    public void setCantidadBebida(int cantidadBebida) {
        this.cantidadBebida = cantidadBebida;
    }

    public Double getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(Double precioBebida) {
        this.precioBebida = precioBebida;
    }


}



