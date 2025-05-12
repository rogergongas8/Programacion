package monlau;

import monlau.dao.ProductoDAO;
import monlau.dao.ProductoDAOImpl;
import monlau.model.Producto;

import java.util.Scanner;

public class ProductoManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAOImpl();
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENU:");
            System.out.println("1. Crear producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Leer Producto por ID");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el id del producto: ");
                    int id = sc.nextInt();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese el precio: ");
                    double precio = sc.nextDouble();

                    productoDAO.insert(new Producto(id, nombre, precio));
                    System.out.println("Producto creado exitosamente");
                }
                case 2 -> {
                    System.out.print("Ingrese el id del producto a actualizar: ");
                    int idActualizar = sc.nextInt();
                    Producto productoExistente = productoDAO.read(idActualizar);

                    if (productoExistente == null) {
                        System.out.println("No se encontro un producto con ese ID");
                    } else {
                        System.out.print("Ingrese el nuevo nombre (actual: " + productoExistente.getNombre() + "): ");
                        String nuevoNombre = sc.next();
                        System.out.print("Ingrese el nuevo precio (actual: " + productoExistente.getPrecio() + "): ");
                        double nuevoPrecio = sc.nextDouble();

                        productoDAO.update(new Producto(idActualizar, nuevoNombre, nuevoPrecio));
                        System.out.println("Producto actualizado exitosamente");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el id del producto a consultar: ");
                    Producto productoConsultado = productoDAO.read(sc.nextInt());

                    if (productoConsultado != null) {
                        System.out.println("Nombre: " + productoConsultado.getNombre() + ", Precio: " + productoConsultado.getPrecio());
                    } else {
                        System.out.println("No se encontro un producto con ese ID");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el id del producto a eliminar: ");
                    Producto productoAEliminar = productoDAO.read(sc.nextInt());

                    if (productoAEliminar != null) {
                        productoDAO.delete(productoAEliminar);
                        System.out.println("Producto eliminado exitosamente");
                    } else {
                        System.out.println("No se encontro un producto con ese ID");
                    }
                }
                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
        sc.close();
    }
}
