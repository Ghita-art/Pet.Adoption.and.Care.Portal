package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestPetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponsePetDTO;

import java.util.List;

public interface PetServices {

    PetDTO getPetById(Long id);

    ResponsePetDTO createPet(RequestPetDTO requestPetDTO);

    List<PetDTO> getPets();

    PetDTO updatePetById(Long id, PetDTO petDTO);

    void deletePetById(Long id);

}
