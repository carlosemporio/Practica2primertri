package com.mitienda.spring.menu;

import com.mitienda.spring.controllers.CategoryController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.mitienda.spring.models.Categoria;

public class menuCategorias implements crud {

   CategoryController ctrl = new CategoryController().getInstance();
	
    List<Categoria> categoriasLista = new ArrayList<>();

    public static Scanner keyboard = new Scanner(System.in);

    Categoria cat = new Categoria();

    public menuCategorias() {

    }

    public static menuCategorias menu = new menuCategorias();

    public static void mostrarCategorias() {

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

        categoriasLista = ctrl.list();

        for (int i = 0; i < categoriasLista.size(); i++) {

            System.out.println(i + " = " + categoriasLista.get(i));

        }
    }

    @Override
    public void modificar() {

        System.out.println("Dime la posicion de la Categoria que quieres Modificar");
        keyboard.reset();

        String eleccion;
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);
        ctrl.findById(opcion);

        System.out.println("Dime El nuevo nombre de la Categoria");
        keyboard.reset();
        String nuevoNombre = keyboard.nextLine();
        cat.setNombre(nuevoNombre);

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime el ID de la Categoria que quieres Borrar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);
        ctrl.deleteById(opcion);

    }

    @Override
    public void crear() {

        System.out.println("Dime el nombre del la nueva categoria");

        keyboard.reset();

        String nuevaCat = keyboard.nextLine();

        cat.setNombre(nuevaCat);
        ctrl.save(cat);

        System.out.println("Se ha insertado la nueva Categoria");

    }
}
