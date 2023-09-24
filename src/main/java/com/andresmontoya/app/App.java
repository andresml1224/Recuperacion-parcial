package com.andresmontoya.app;
import com.andresmontoya.domain.Maquina;
import com.andresmontoya.domain.Productos;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Maquina maquina = new Maquina();

            Productos producto1 = new Productos("1", "Coca-Cola", (short) 1000, (byte) 8, (byte) 10);
            Productos producto2 = new Productos("2", "Pepsi", (short) 1200, (byte) 4, (byte) 10);
            Productos producto3 = new Productos("3", "Sprite", (short) 900, (byte) 3, (byte) 10);
            Productos producto4 = new Productos("4", "Fanta", (short) 1100, (byte) 0, (byte) 10);
            Productos producto5 = new Productos("5", "Bimbo", (short) 3000, (byte) 8, (byte) 10);
            Productos producto6 = new Productos("6", "Pan de bono", (short) 2500, (byte) 3, (byte) 10);
            Productos producto7 = new Productos("7", "Galletas", (short) 1500, (byte) 9, (byte) 10);
            Productos producto8 = new Productos("8", "Chocolates", (short) 2000, (byte) 10, (byte) 10);
            Productos producto9 = new Productos("9", "Gomitas", (short) 1800, (byte) 2, (byte) 10);
            Productos producto10 = new Productos("10", "Cheetos", (short) 1700, (byte) 7, (byte) 10);

            maquina.cargarProducto(producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8, producto9, producto10);
            List<Productos> productos = maquina.consultarTotalUnidadesPorProductos();

            int opcion;
            do {
                System.out.println("\n\n** Menú de la máquina expendedora **");
                System.out.println("1. Consultar productos agotados");
                System.out.println("2. Consultar unidades de un producto");
                System.out.println("3. Sacar producto por nombre");
                System.out.println("4. Sacar producto por código");
                System.out.println("5. Consultar inventario total");
                System.out.println("6. Salir");
                System.out.print("Ingrese su opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        // Consultamos los productos agotados
                        List<Productos> productosAgotados = maquina.consultarProductosAgotados();
                        if (productosAgotados.isEmpty()) {
                            System.out.println("No hay productos agotados");
                        } else {
                            System.out.println("Productos agotados:");
                            productosAgotados.forEach(producto -> {
                                System.out.println(producto.getNombre());
                            });
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese el código o nombre del producto: ");
                        String codigoNombreProducto = sc.nextLine();
                        Productos producto = maquina.consultarUnidadesDeProductoCodigo(codigoNombreProducto);
                        if (producto == null) {
                            producto = maquina.consultarUnidadesDeProductoNombre(codigoNombreProducto);
                        }
                        if (producto == null) {
                            System.out.println("Producto no encontrado");
                        } else {
                            System.out.println("Unidades disponibles: " + producto.getCantidadActual());
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombreProducto = sc.nextLine();
                        short dinero = 0;
                        System.out.print("Ingrese el dinero: ");
                        dinero = Short.parseShort(sc.nextLine());
                        maquina.sacarProductoNombre(nombreProducto, dinero);
                        break;
                    case 4:
                        System.out.print("Ingrese el código del producto: ");
                        String codigoProducto = sc.nextLine();
                        short dinero1;
                        System.out.print("Ingrese el dinero: ");
                        dinero1 = Short.parseShort(sc.nextLine());
                        maquina.sacarProductoCodigo(codigoProducto, dinero1);
                        break;
                    case 5:
                        if (!productos.isEmpty()) {
                            productos.forEach(prod -> {
                                System.out.println(prod.getCodigo() + " - " + prod.getNombre() + " - " + prod.getCantidadActual());
                            });
                        } else {
                            System.out.println("No hay productos disponibles");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }while(opcion != 6);
        }
}
