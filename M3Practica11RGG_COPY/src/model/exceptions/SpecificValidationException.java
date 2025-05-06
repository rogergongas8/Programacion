package model.exceptions;

public class SpecificValidationException extends ValidationException {
    public SpecificValidationException(String message) {
        super(message);
    }
}