package com.mitienda.spring.menu;


import com.mitienda.spring.controllers.FacturaLineaController;
import com.mitienda.spring.models.FacturaLinea;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuFacturaLinea implements crud {

    List<FacturaLinea> facturaLineaLista = new ArrayList<>();

    FacturaLineaController ctrl = FacturaLineaController.getInstance();

    FacturaLinea faclin = new FacturaLinea();
    public static Scanner keyboard = new Scanner(System.in);

    public menuFacturaLinea() {

    }

    public static menuFacturaLinea menu = new menuFacturaLinea();

    public static void mostrarFactura() {

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

        facturaLineaLista = ctrl.list();

        for (int i = 0; i < facturaLineaLista.size(); i++) {

            System.out.println(i + " = " + facturaLineaLista.get(i));

        }
    }

    @Override
    public void modificar() {

        String eleccion;

        System.out.println("Dime ID del FacturaLinea que quieres Modificar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);

        ctrl.findById(opcion);
        
        System.out.println("Dime el nuevo ID de la Factura Linea");
        String nuevoID = keyboard.nextLine();
        faclin.setId_factura(Integer.parseInt(nuevoID));
        System.out.println("Dime el nuevo nombre de la Factura");
        String nuevoNombre =  keyboard.nextLine();
        faclin.setNombre(nuevoNombre);
        System.out.println("Dime el nuevo Precio");
        String nuevoPrecio =keyboard.nextLine();
        faclin.setPrecio(Integer.parseInt(nuevoPrecio));

        ctrl.save(faclin);

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime el ID de la FacturaLinea que quieres Borrar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);

        ctrl.deleteById(opcion);

    }

    @Override
    public void crear() {

        keyboard.reset();
       
      
        System.out.println("Dime el ID de la Factura Linea");
        String nuevoID = keyboard.nextLine();
        faclin.setId_factura(Integer.parseInt(nuevoID));
        System.out.println("Dime el nombre de la Factura Linea");
        String nuevoNombre =  keyboard.nextLine();
        faclin.setNombre(nuevoNombre);
        System.out.println("Dime el Precio de la Factura Linea");
        String nuevoPrecio =keyboard.nextLine();
        faclin.setPrecio(Integer.parseInt(nuevoPrecio));

        ctrl.save(faclin);
    }

}
