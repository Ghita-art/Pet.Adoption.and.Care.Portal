package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.AdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;

public interface AdoptionService {
    ResponseAdoptionDTO createAdoption(RequestAdoptionDTO requestAdoptionDTO);

    ResponseAdoptionDTO updateAdoption(Long adoptionId, RequestAdoptionDTO requestAdoptionDTO);

    AdoptionDTO getAdoptionById(Long id);

    void deleteAdoptionById(Long id);

}
