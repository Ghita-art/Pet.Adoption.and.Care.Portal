package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class AdoptionDeleteException extends RuntimeException {
    public AdoptionDeleteException(String id) {
        super("Adoption with the ID " + id + " not found");
    }
}