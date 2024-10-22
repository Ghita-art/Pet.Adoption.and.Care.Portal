package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseUpdatedAdoptionDTO;
import jakarta.transaction.Transactional;

public interface UpdatedAdoptionService {

    @Transactional
    ResponseUpdatedAdoptionDTO createUpdatedAdoption(ResponseUpdatedAdoptionDTO requestAdoptionDTO);
}

