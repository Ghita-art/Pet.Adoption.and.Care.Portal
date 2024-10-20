package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class AdoptionNotFoundException extends RuntimeException {
    public AdoptionNotFoundException(String id) {
        super("Adoption with the ID " + id + " not found");
    }
}
