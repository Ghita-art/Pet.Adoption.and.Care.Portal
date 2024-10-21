package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class OwnerDuplicateEmailException extends RuntimeException {
    public OwnerDuplicateEmailException(String message) {
        super(message);
    }
}
