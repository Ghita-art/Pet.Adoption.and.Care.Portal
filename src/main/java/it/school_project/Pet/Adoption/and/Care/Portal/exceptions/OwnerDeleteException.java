package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class OwnerDeleteException extends RuntimeException {
    public OwnerDeleteException(String id) {
        super("Owner with the ID " + id + " not found");
    }
}