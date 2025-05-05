package view.console;

import java.io.IOException;
import java.util.Scanner;
import model.Funciones;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Funciones funciones = new Funciones();

    public static void main(String[] args) throws IOException {

        String option;

        do {

            System.out.println("");
            System.out.println("1.- Create a folder with your name: ");
            System.out.println("2.- Create a file");
            System.out.println("3.- Show list of files ");
            System.out.println("4.- Show file content");
            System.out.println("5.- Modify a file");
            System.out.println("6.- Delete a file");
            System.out.println("7.- Count characters");
            System.out.println("8.- Count words");
            System.out.println("9.- Replace words");
            System.out.println("10.- Create a pdf");
            System.out.println("z.- Salir");

            System.out.println("");

            System.out.println("Option:");
            option = scan.next();

            System.out.println("");
            System.out.println("");

            switch (option) {
                case "1":
                    createFolder();
                    break;
                case "2":
                    createFile();
                    break;
                case "3":
                    showListFiles();
                    break;
                case "4":
                    showFile();
                    break;
                case "5":
                    overWriteFile();
                    break;
                case "6":
                    deleteFile();
                    break;
                case "7":
                    countChars();
                    break;
                case "8":
                    countWords();
                    break;
                case "9":
                    swapWords();
                    break;
                case "10":
                    printPDF();
                    break;
                case "z":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Incorrect Option.");

            }
        } while (!option.equals("z"));

    }

     private static void createFolder() {
        try {
            System.out.print("Folder path: ");
            String path = scan.next();
            funciones.createFolder(path);
        } catch (Exception e) {
            System.out.println("Error creating folder.");
        }
    }

    private static void createFile() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            scan.nextLine();
            System.out.print("Content: ");
            String content = scan.nextLine();
            funciones.createFile(path, fileName, content);
        } catch (Exception e) {
            System.out.println("Error creating file.");
        }
    }

    private static void showListFiles() {
        try {
            System.out.print("Folder path: ");
            String path = scan.next();
            String[] files = funciones.showListFiles(path);
            for (String file : files) {
                System.out.println(file);
            }
        } catch (Exception e) {
            System.out.println("Error listing files.");
        }
    }

    private static void showFile() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            System.out.println(funciones.showFile(path, fileName));
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    private static void overWriteFile() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            scan.nextLine();
            System.out.print("New content: ");
            String content = scan.nextLine();
            boolean result = funciones.overWriteFile(path, fileName, content);
            System.out.println(result ? "File updated." : "File does not exist.");
        } catch (Exception e) {
            System.out.println("Error updating file.");
        }
    }

    private static void deleteFile() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            funciones.deleteFile(path, fileName);
            System.out.println("File deleted if it existed.");
        } catch (Exception e) {
            System.out.println("Error deleting file.");
        }
    }

    private static void countChars() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            int count = funciones.countChars(path, fileName);
            System.out.println("Character count: " + count);
        } catch (Exception e) {
            System.out.println("Error counting characters.");
        }
    }

    private static void countWords() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            int count = funciones.countWords(path, fileName);
            System.out.println("Word count: " + count);
        } catch (Exception e) {
            System.out.println("Error counting words.");
        }
    }

    private static void swapWords() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            System.out.print("Old word: ");
            String oldWord = scan.next();
            System.out.print("New word: ");
            String newWord = scan.next();
            String updated = funciones.swapWords(path, fileName, oldWord, newWord);
            System.out.println("Updated content:\n" + updated);
        } catch (Exception e) {
            System.out.println("Error replacing words.");
        }
    }

    private static void printPDF() {
        try {
            System.out.print("File path: ");
            String path = scan.next();
            System.out.print("File name: ");
            String fileName = scan.next();
            funciones.printPDF(path, fileName);
            System.out.println("PDF created.");
        } catch (Exception e) {
            System.out.println("Error creating PDF.");
        }
    }
}