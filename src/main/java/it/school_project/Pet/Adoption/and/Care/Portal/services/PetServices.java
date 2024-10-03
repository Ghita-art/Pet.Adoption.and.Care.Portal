package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.entities.Pet;

public interface PetServices {
    PetDTO createPet(PetDTO petDTO);
}
