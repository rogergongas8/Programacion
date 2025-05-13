package org.example.demojdbc;

import org.example.demojdbc.model.Persona;
import org.example.demojdbc.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoJdbcApplication implements CommandLineRunner {

    @Autowired
    private PersonaRepository personaRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Seleccione una opcion: ");

            if (opcion == 1) {
                insertarPersona(scanner);
            } else if (opcion == 2) {
                buscarTodas();
            } else if (opcion == 3) {
                buscarUna(scanner);
            } else if (opcion == 4) {
                borrarUna(scanner);
            } else if (opcion == 5) {
                borrarTodas();
            } else if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                running = false;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Insertar persona");
        System.out.println("2. Buscar todas las personas");
        System.out.println("3. Buscar una persona por nombre");
        System.out.println("4. Borrar una persona por nombre");
        System.out.println("5. Borrar todas las personas");
        System.out.println("0. Salir");
    }

    private int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void insertarPersona(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();
        int edad = leerEntero(scanner, "Ingrese la edad: ");

        Persona persona = new Persona(nombre, apellidos, edad);
        personaRepository.insertar(persona);
        System.out.println("Persona insertada correctamente");
    }

    private void buscarTodas() {
        System.out.println("Listado de todas las personas:");
        personaRepository.buscarTodos().forEach(System.out::println);
    }

    private void buscarUna(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre de la persona a buscar: ");
        String nombre = scanner.nextLine();
        Persona persona = personaRepository.buscarUno(nombre);

        if (persona != null) {
            System.out.println("Persona encontrada: " + persona);
        } else {
            System.out.println("No se encontro ninguna persona con ese nombre.");
        }
    }

    private void borrarUna(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre de la persona a borrar: ");
        String nombre = scanner.nextLine();

        Persona persona = personaRepository.buscarUno(nombre);
        if (persona != null) {
            personaRepository.borrar(persona);
            System.out.println("Persona borrada correctamente.");
        } else {
            System.out.println("No se encontro ninguna persona con ese nombre.");
        }
    }

    private void borrarTodas() {
        personaRepository.borrarTodos();
        System.out.println("Todas las personas han sido borradas.");
    }
}
