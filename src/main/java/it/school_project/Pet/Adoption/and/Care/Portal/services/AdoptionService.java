package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.AdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;

import java.util.List;

public interface AdoptionService {
    ResponseAdoptionDTO createAdoption(RequestAdoptionDTO requestAdoptionDTO);

    ResponseAdoptionDTO updateAdoption(Long id,Owner owner);

    List<ResponseAdoptionDTO> getAdoptions(Owner owner, String status, Long id);

}
