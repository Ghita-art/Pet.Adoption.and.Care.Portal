package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.OwnerNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.PetNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseUpdatedAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.UpdatedAdoption;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.UpdatedAdoptionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdatedAdoptionServiceImpl implements UpdatedAdoptionService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final UpdatedAdoptionRepository updatedAdoptionRepository;
    private final ObjectMapper objectMapper;

    public UpdatedAdoptionServiceImpl(OwnerRepository ownerRepository,
                                      PetRepository petRepository,
                                      UpdatedAdoptionRepository updatedAdoptionRepository,
                                      ObjectMapper objectMapper) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.updatedAdoptionRepository = updatedAdoptionRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional
    @Override
    public ResponseUpdatedAdoptionDTO createUpdatedAdoption(ResponseUpdatedAdoptionDTO requestAdoptionDTO) {
        UpdatedAdoption updatedAdoptionEntity = objectMapper.convertValue(requestAdoptionDTO, UpdatedAdoption.class);
        UpdatedAdoption updatedAdoptionEntityResponse = updatedAdoptionRepository.save(updatedAdoptionEntity);
        log.info("Updated adoption with the id {} was saved",updatedAdoptionEntityResponse.getId());

        return objectMapper.convertValue(updatedAdoptionEntityResponse, ResponseUpdatedAdoptionDTO.class);
    }
}


