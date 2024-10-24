package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestPetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponsePetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetServices {

    PetDTO getPetById(Long id);

    ResponsePetDTO createPet(RequestPetDTO requestPetDTO);

    List<PetDTO> getPets();

  PetDTO updatePetById(Long id, PetDTO petDTO);

  void deletePetById(Long id);

}
