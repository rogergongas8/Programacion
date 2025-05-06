package model.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.exceptions.ValidationException;
import model.exceptions.SpecificValidationException;

public class UserDataValidations {

    public static void checkId(int typeDoc, String id) throws ValidationException, SpecificValidationException {
        if (typeDoc == 1) {
            if (id.length() != 9) {
                throw new ValidationException("El DNI debe tener 9 caracteres");
            }
            
            String nums = id.substring(0, 8);
            char letra = id.charAt(8);
            
            for (int i = 0; i < nums.length(); i++) {
                if (!Character.isDigit(nums.charAt(i))) {
                    throw new ValidationException("Los primeros 8 caracteres deben ser dígitos");
                }
            }
            
            char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
            int numeros = Integer.parseInt(nums);
            int resto = numeros % 23;
            
            if (letra != letras[resto]) {
                throw new SpecificValidationException("La letra del DNI no es válida");
            }
        }
    }

    public static void checkFormatDate(String dateStr) throws ValidationException {
        if (dateStr.length() != 10 || !dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new ValidationException("El formato de fecha debe ser dd/mm/aaaa");
        }
        
        String[] fecha = dateStr.split("/");
        int day = Integer.parseInt(fecha[0]);
        int month = Integer.parseInt(fecha[1]);
        int year = Integer.parseInt(fecha[2]);

        if (month < 1 || month > 12) {
            throw new ValidationException("El mes debe estar entre 1 y 12");
        }

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        

        if (month == 2 && isLeapYear(year)) {
            monthDays[1] = 29;
        }

        if (day < 1 || day > monthDays[month - 1]) {
            throw new ValidationException("Día no válido para el mes especificado");
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static double checkAge(String birth) throws ParseException, ValidationException {
        checkFormatDate(birth); 
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = dateFormat.parse(birth);
        Date currentDate = new Date();

        long diff = currentDate.getTime() - birthdate.getTime();
        double years = diff / (1000L * 60 * 60 * 24 * 365);

        if (years < 0) {
            throw new ValidationException("La fecha de nacimiento no puede ser futura");
        }

        return years;
    }

    public static void checkPostalCode(String zip) throws ValidationException {
        if (!zip.matches("\\d{5}")) {
            throw new ValidationException("El código postal debe tener 5 dígitos");
        }
    }

    public static void isNumeric(String num) throws ValidationException {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                throw new ValidationException("El valor debe contener solo dígitos");
            }
        }
    }

    public static void isAlphabetic(String str) throws ValidationException {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                throw new ValidationException("El valor debe contener solo letras");
            }
        }
    }

    public static void checkEmail(String email) throws ValidationException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new ValidationException("El email debe contener @ y .");
        }
        
        int atPosition = email.indexOf("@");
        int dotPosition = email.lastIndexOf(".");
        
        if (atPosition < 1 || dotPosition <= atPosition + 1 || dotPosition == email.length() - 1) {
            throw new ValidationException("Formato de email no válido");
        }
    }

    public static void checkName(String name) throws ValidationException {
        if (name.length() > 30) {
            throw new ValidationException("El nombre no puede tener más de 30 caracteres");
        }
        
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                throw new ValidationException("El nombre solo puede contener letras");
            }
        }
    }
}