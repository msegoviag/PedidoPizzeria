package com.example.pedidopizzeria;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private String nombre;
    private String cantidad;
    private Double precio;

    public Item(String nombre, String cantidad, Double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Item() {
        this.nombre = "Pizza Barbacoa";
        this.cantidad = "5";
        this.precio = 8.00;
    }


    public double getSubTotal() {
        return Integer.parseInt(cantidad) * precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item bebida = (Item) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantidad, precio);
    }
}
