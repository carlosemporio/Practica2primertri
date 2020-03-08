package com.mitienda.spring.menu;

import com.mitienda.spring.controllers.ProductoController;
import com.mitienda.spring.models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuProducto implements crud {

    List<Producto> productosLista = new ArrayList<>();
    ProductoController ctrl = ProductoController.getInstance();
    public static Scanner keyboard = new Scanner(System.in);

    Producto pro = new Producto();

    public menuProducto() {

    }

    public static menuClientes menu = new menuClientes();

    public static void mostrarProducto() {

        boolean salida = true;

        int opcion;
        System.out.print("Elige una opcion\n");

        System.out.print("1 para Ver\n");
        System.out.print("2 para Crear\n");
        System.out.print("3 para Borrar\n");
        System.out.print("4 para Modificar\n");
        System.out.print("5 para Volver al menu Principal\n");

        do {

            opcion = Integer.parseInt(keyboard.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido ver");
                    menu.ver();
                    break;
                case 2:
                    System.out.println("Has elegido crear");
                    menu.crear();
                    break;
                case 3:
                    System.out.println("Has elegido Borrar");
                    menu.borrar();
                    break;
                case 4:
                    System.out.println("Has elegido modificar");
                    menu.modificar();
                    break;
                case 5:
                    System.out.println("Has elegido volver al Menu Principal");
                    menuPrincipal.iniciaMenu();
                    break;
                default:
                    break;
            }

        } while (salida);

        System.out.print("Gracias por usar la apliacion");

    }

    @Override
    public void ver() {

        productosLista = ctrl.list();

        for (int i = 0; i < productosLista.size(); i++) {

            System.out.println(i + " = " + productosLista.get(i));

        }
    }

    @Override
    public void modificar() {

        String eleccion;

        System.out.println("Dime la Id del Producto que quieres Modificar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);
        ctrl.findById(opcion);

        System.out.println("Dime el nuevo Nombre del producto");
        String nuevoProNombre = keyboard.nextLine();
        pro.setNombre(nuevoProNombre);
        System.out.println("Dime el nuevo precio del Producto");
        String nuevoPrecio = keyboard.nextLine();
        pro.setPrecio(Integer.parseInt(nuevoPrecio));
        System.out.println("Dime el Nuevo Stock del producto");
        String nuevoStock = keyboard.nextLine();
        pro.setStock(Integer.parseInt(nuevoStock));
        System.out.println("Dime el nuevo id del producto");
        String nuevoId = keyboard.nextLine();
        pro.setId_categoria(Integer.parseInt(nuevoId));

        ctrl.save(pro);

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la ID del Producto que quieres Borrar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);

        ctrl.deleteById(opcion);

    }

    @Override
    public void crear() {

        keyboard.reset();
        System.out.println("Dime el nuevo Nombre del producto");
        String nuevoProNombre = keyboard.nextLine();
        pro.setNombre(nuevoProNombre);
        System.out.println("Dime el nuevo precio del Producto");
        String nuevoPrecio = keyboard.nextLine();
        pro.setPrecio(Integer.parseInt(nuevoPrecio));
        System.out.println("Dime el Nuevo Stock del producto");
        String nuevoStock = keyboard.nextLine();
        pro.setStock(Integer.parseInt(nuevoStock));
        System.out.println("Dime el nuevo id del producto");
        String nuevoId = keyboard.nextLine();
        pro.setId_categoria(Integer.parseInt(nuevoId));

        ctrl.save(pro);

        System.out.println("Se ha insertado el nuevo Producto");

    }
}
