package com.andresmontoya.domain;

public class Productos {

    private String codigo;
    private String nombre;
    private short precio;
    private byte cantidadActual;
    private byte cantidadMaxima;


    public Productos(String codigo, String nombre, short precio, byte cantidadActual, byte cantidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadActual = cantidadActual;
        this.cantidadMaxima = 10;
    }

    public Productos(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getPrecio() {
        return precio;
    }

    public void setPrecio(short precio) {
        this.precio = precio;
    }

    public byte getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(byte cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
}
