package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoJdbcApplication implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Selecciona una opcion: ");

            if (opcion == 1) {
                insertarProducto(scanner);
            } else if (opcion == 2) {
                buscarTodosProductos();
            } else if (opcion == 3) {
                buscarProductoPorNombre(scanner);
            } else if (opcion == 4) {
                borrarProductoPorNombre(scanner);
            } else if (opcion == 5) {
                borrarTodosProductos();
            } else if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                running = false;
            } else {
                System.out.println("Opción no valida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n MENU");
        System.out.println("1. Insertar producto");
        System.out.println("2. Buscar todos los productos");
        System.out.println("3. Buscar producto por nombre");
        System.out.println("4. Borrar producto por nombre");
        System.out.println("5. Borrar todos los productos");
        System.out.println("0. Salir");
    }

    private int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Eso no es valida, escribe otro numero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double leerDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Eso no es valida, escribe otro numero: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void insertarProducto(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Escribe el nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio = leerDouble(scanner, "Escribe el precio: ");
        int stock = leerEntero(scanner, "Escribe el stock: ");

        Producto producto = new Producto(nombre, precio, stock);
        productoRepository.insertar(producto);
        System.out.println("Producto insertado correctamente");
    }

    private void buscarTodosProductos() {
        System.out.println("Listado de todos los productos:");
        productoRepository.buscarTodos().forEach(System.out::println);
    }

    private void buscarProductoPorNombre(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Escribe el nombre del producto: ");
        String nombre = scanner.nextLine();
        Producto producto = productoRepository.buscarPorNombre(nombre);

        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("No se encontro ningun producto con ese nombre.");
        }
    }

    private void borrarProductoPorNombre(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del producto a borrar: ");
        String nombre = scanner.nextLine();

        Producto producto = productoRepository.buscarPorNombre(nombre);
        if (producto != null) {
            productoRepository.borrar(nombre);
            System.out.println("Producto borrado correctamente.");
        } else {
            System.out.println("No se encontro ningun producto con ese nombre.");
        }
    }

    private void borrarTodosProductos() {
        productoRepository.borrarTodos();
        System.out.println("Todos los productos han sido borrados.");
    }
}