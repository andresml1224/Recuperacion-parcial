package com.andresmontoya.domain;

import java.util.ArrayList;
import java.util.List;

public class Maquina {
    private List<Productos> productos;

    public Maquina() {
        this.productos = new ArrayList<>();
    }

    public void cargarProducto(Productos producto1, Productos producto2, Productos producto3, Productos producto4,
                               Productos producto5, Productos producto6, Productos producto7, Productos producto8, Productos producto9, Productos producto10){
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
    }

    public void sacarProductoNombre(String nombre, short dinero){
        boolean existeProducto = false;
        Productos producto = new Productos();
        for (Productos prod : productos){
            if (prod.getNombre(). equals(nombre)){
                existeProducto = true;
                producto = prod;
            }
        }
        if (existeProducto){
            if (producto.getNombre().equals(nombre) && producto.getCantidadActual() >0 && producto.getPrecio()<=dinero){
                byte cantidadActual = (byte) (producto.getCantidadActual() -1);
                producto.setCantidadActual(cantidadActual);
                System.out.println("Retire su " + producto.getNombre() + " " +
                        "su cambio es de " + (dinero - producto.getPrecio()) + " pesos");
            }
            else {
                System.out.println("Producto no disponible, " +
                        " su cambio es de: " + dinero + " pesos");
            }
        } else {
            System.out.println("Producto no disponible, " +
                    " su cambio es de: " + dinero + " pesos");
        }
    }

    public void sacarProductoCodigo(String codigo, short dinero){
        boolean existeProducto = false;
        Productos producto = new Productos();
        for (Productos prod : productos){
            if (prod.getNombre(). equals(codigo)){
                existeProducto = true;
                producto = prod;
            }
        }
        if (existeProducto){
            if (producto.getNombre().equals(codigo) && producto.getCantidadActual() >0 && producto.getPrecio()<=dinero){
                byte cantidadActual = (byte) (producto.getCantidadActual() -1);
                producto.setCantidadActual(cantidadActual);
                System.out.println("Retire su " + producto.getNombre() + " " +
                        "su cambio es de " + (dinero - producto.getPrecio()) + " pesos");
            }
            else {
                System.out.println("Producto no disponible, " +
                        " su cambio es de: " + dinero + " pesos");
            }
        } else {
            System.out.println("Producto no disponible, " +
                    " su cambio es de: " + dinero + " pesos");
        }
    }

    public List<Productos> consultarProductosAgotados(){
        List<Productos> productosAgotados = new ArrayList<>();
        productos.forEach(producto -> {
            if (producto.getCantidadActual()==0){
                productosAgotados.add(producto);
            }
        });
        return productosAgotados;
    }

    public Productos consultarUnidadesDeProductoCodigo(String codigo){
        Productos producto = new Productos();
        for (Productos prod : productos){
            if (prod.getCodigo().equals(codigo)){
                producto = prod;
                break;
            }
        }
        return producto;
    }

    public Productos consultarUnidadesDeProductoNombre(String nombre){
        Productos producto = new Productos();
        for (Productos prod : productos){
            if (prod.getCodigo().equals(nombre)){
                producto = prod;
                break;
            }
        }
        return producto;
    }

    public List<Productos> consultarTotalUnidadesPorProductos(){
        List<Productos> inventarioTodos = new ArrayList<>();
        productos.forEach(producto -> {
            inventarioTodos.add(producto);
        });
        return inventarioTodos;
    }
}
