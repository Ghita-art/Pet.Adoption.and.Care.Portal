package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class PetDeleteException extends RuntimeException {
    public PetDeleteException(String id) {
        super("Adoption with the ID " + id + " not found");
    }
}