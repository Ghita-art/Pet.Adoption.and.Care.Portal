package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(String id) {
        super("Pet with ID " + id + " not found");
    }
}


