package view.console;

import java.text.ParseException;
import java.util.Scanner;
import model.validations.UserDataValidations;
import model.exceptions.ValidationException;
import model.exceptions.SpecificValidationException;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String option = "";
        do {
            System.out.println("\n\n1.-Tester checkId");
            System.out.println("2.-Tester checkFormatDate");
            System.out.println("3.-Tester checkCalculateAge");
            System.out.println("4.-Tester checkPostalCode");
            System.out.println("5.-Tester checkNumeric");
            System.out.println("6.-Tester checkAlphabetic");
            System.out.println("7.-Tester checkEmail");
            System.out.println("8.-Tester checkName");
            System.out.println("z.-Salir");
            System.out.print("Option: ");
            option = scan.next();

            System.out.println();

            try {
                switch (option) {
                    case "1":
                        testCheckId();
                        break;
                    case "2":
                        testCheckFormatDate();
                        break;
                    case "3":
                        testCheckCalculateAge();
                        break;
                    case "4":
                        testCheckPostalCode();
                        break;
                    case "5":
                        testCheckNumeric();
                        break;
                    case "6":
                        testCheckAlphabetic();
                        break;
                    case "7":
                        testCheckEmail();
                        break;
                    case "8":
                        testCheckName();
                        break;
                    case "z":
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Incorrect Option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!option.equals("z"));
    }

    static void testCheckId() throws ValidationException, SpecificValidationException {
        System.out.println("-NIF VALIDATOR-");
        System.out.print("Enter your ID: ");
        String ID = scan.next();
        try {
            UserDataValidations.checkId(1, ID);
            System.out.println("Correct ID");
        } catch (SpecificValidationException e) {
            System.out.println("Error específico: " + e.getMessage());
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckFormatDate() throws ValidationException {
        System.out.println("Format Date Validator");
        System.out.println("Insert any date you want (format: dd/mm/aaaa).");
        String date = scan.next();
        try {
            UserDataValidations.checkFormatDate(date);
            System.out.println("Correct format date");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckCalculateAge() throws ParseException, ValidationException {
        System.out.println("Age calculator");
        System.out.println("Insert your birth date (format: dd/mm/aaaa) ");
        String date = scan.next();
        try {
            double age = UserDataValidations.checkAge(date);
            System.out.println("Your age is " + age);
        } catch (ValidationException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckPostalCode() throws ValidationException {
        System.out.println("Postal Code Validator");
        System.out.print("Insert the postal code: ");
        String zip = scan.next();
        try {
            UserDataValidations.checkPostalCode(zip);
            System.out.println("Your postal code is right.");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckNumeric() throws ValidationException {
        System.out.println("Numeric Validator");
        System.out.print("Insert something: ");
        String num = scan.next();
        try {
            UserDataValidations.isNumeric(num);
            System.out.println("They're all nums");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckAlphabetic() throws ValidationException {
        System.out.println("Alphabetic Validator");
        System.out.print("Insert something: ");
        String character = scan.next();
        try {
            UserDataValidations.isAlphabetic(character);
            System.out.println("They're all letters");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckEmail() throws ValidationException {
        System.out.println("Email Validator");
        System.out.print("Insert your Email: ");
        String email = scan.next();
        try {
            UserDataValidations.checkEmail(email);
            System.out.println("Your Email is correct");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testCheckName() throws ValidationException {
        System.out.println("Name Validator");
        System.out.print("Insert your name: ");
        String name = scan.next();
        try {
            UserDataValidations.checkName(name);
            System.out.println("Nice name ;)");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
