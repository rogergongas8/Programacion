package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funciones {

    public void createFolder(String folderPath) {
        File folder = new File(folderPath); // Crea un objeto file para la carpeta
        if (!folder.exists()) { // Verifica si la carpeta existe 
            folder.mkdirs(); //Crea la carpeta o la subcarpeta
        }
    }

    public void createFile(String path, String fileName, String content) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        try (FileWriter fw = new FileWriter(file, true)) { // Abre el archivo para poder escribir 
            fw.write(content); // Escribe el contenido en el archivo
        } catch (IOException e) { // Si ocurre un error al escribir
            System.out.println("No se pudo crear o escribir en el archivo."); // Imprime un mensaje de error
        }
    }

    public String[] showListFiles(String path) {
        File folder = new File(path); // Crea un objeto con la ruta del directorio
        if (folder.exists() && folder.isDirectory()) { // Verifica si la ruta existe y es un directorio
            return folder.list(); // Devuelve una lista de los archivos y carpetas dentro del directorio
        }
        return new String[0];  // Si no es un directorio o no existe, devuelve un array vacio
    }

    public String showFile(String path, String fileName) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        StringBuilder content = new StringBuilder(); // Crea un StringBuilder para almacenar el contenido
        try (Scanner scan = new Scanner(file)) { // Abre el archivo para leerlo
            while (scan.hasNextLine()) { // Lee cada linea del archivo
                content.append(scan.nextLine()).append("\n"); // Agrega cada linea al contenido
            }
        } catch (IOException e) { // Si ocurre un error al leer el archivo
            System.out.println("No se pudo leer el archivo."); // Imprime un mensaje de error
        }
        return content.toString(); // Devuelve todo el contenido del archivo como una cadena
    }

    public boolean overWriteFile(String path, String fileName, String newContent) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        if (!file.exists()) { // Verifica si el archivo no existe
            return false; // Si no existe, devuelve false
        }
        try (FileWriter fw = new FileWriter(file, false)) { // Abre el archivo
            fw.write(newContent); // Sobrescribe el archivo con el nuevo contenido
            return true; // Devuelve true si el archivo fue sobrescrito
        } catch (IOException e) { // Si ocurre un error al sobrescribir el archivo
            System.out.println("No se pudo sobrescribir el archivo."); // Imprime un mensaje de error
            return false; // Devuelve false si hubo un error
        }
    }

    public void deleteFile(String path, String fileName) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        if (file.exists()) { // Verifica si el archivo existe
            file.delete(); // Elimina el archivo
        }
    }

    public int countChars(String path, String fileName) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        int count = 0; // Inicializa el contador de caracteres
        try (FileReader fr = new FileReader(file)) { // Abre el archivo para leerlo
            while (fr.read() != -1) { // Lee cada caracter del archivo
                count++; // Aumenta el contador por cada carácter leido
            }
        } catch (IOException e) { // Si ocurre un error al leer el archivo
            System.out.println("No se pudo contar los caracteres."); // Imprime un mensaje de error
        }
        return count; // Devuelve el total de caracteres contados
    }

    public int countWords(String path, String fileName) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        int count = 0; // Inicializa el contador de palabras
        try (Scanner scanner = new Scanner(file)) { // Abre el archivo para leerlo
            while (scanner.hasNext()) { // Lee cada palabra del archivo
                scanner.next(); // Lee la siguiente palabra
                count++; // Aumenta el contador por cada palabra leida
            }
        } catch (IOException e) { // Si ocurre un error al leer el archivo
            System.out.println("No se pudo contar las palabras."); // Imprime un mensaje de error
        }
        return count; // Devuelve el total de palabras contadas
    }

    public String swapWords(String path, String fileName, String oldWord, String newWord) {
        File file = new File(path, fileName); // Crea un objeto File con la ruta y nombre del archivo
        StringBuilder content = new StringBuilder(); // Crea un StringBuilder para almacenar el contenido
        try (Scanner scan = new Scanner(file)) { // Abre el archivo para leerlo
            while (scan.hasNextLine()) { // Lee cada linea del archivo
                content.append(scan.nextLine().replace(oldWord, newWord)).append("\n"); // Reemplaza las palabras y agrega la linea al contenido
            }
        } catch (IOException e) { // Si ocurre un error al leer el archivo
            System.out.println("No se pudo leer el archivo."); // Imprime un mensaje de error
            return ""; // Devuelve una cadena vacia si hubo un error
        }

        try (FileWriter fw = new FileWriter(file, false)) { // Abre el archivo para sobrescribirlo
            fw.write(content.toString()); // Sobrescribe el archivo con el contenido actualizado
        } catch (IOException e) { // Si ocurre un error al sobrescribir el archivo
            System.out.println("No se pudo sobrescribir el archivo."); // Imprime un mensaje de error
            return ""; // Devuelve una cadena vacia si hubo un error
        }
        return content.toString(); // Devuelve el contenido actualizado
    }

    public void printPDF(String path, String fileName) {
        File file = new File(path, fileName + ".pdf"); // Crea un archivo con extensión .pdf

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) { // Abre el archivo para escribir
        } catch (IOException e) { // Si ocurre un error al generar el archivo
            System.out.println("No se pudo generar el archivo PDF simulado."); // Imprime un mensaje de error

        }

    }
}
