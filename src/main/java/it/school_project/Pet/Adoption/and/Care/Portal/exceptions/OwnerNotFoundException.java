package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(String id) {
        super("Owner with the ID" + id + "not found");
    }
}
