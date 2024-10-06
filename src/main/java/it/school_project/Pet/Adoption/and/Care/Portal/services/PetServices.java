package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;

import java.util.Optional;

public interface PetServices {

    PetDTO createPet(PetDTO petDTO);

    Optional<Pet> getPetById(Long id);

    Optional<PetDTO> updatePet(Long id, PetDTO petDTO);

     default boolean deletePet(Long id) {
        return false;
    }
}
