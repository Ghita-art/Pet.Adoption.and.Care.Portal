package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(Long id) {
        super("Pet with id " + id + " not found.");
    }
}

