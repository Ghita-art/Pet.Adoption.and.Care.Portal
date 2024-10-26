package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException(String message) {
        super(message);
    }
}