package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.AdoptionDeleteException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.AdoptionNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.OwnerNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.PetNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.*;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.AdoptionRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class AdoptionServiceImpl implements AdoptionService {

    private final ObjectMapper objectMapper;
    private final AdoptionRepository adoptionRepository;
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    public AdoptionServiceImpl(ObjectMapper objectMapper, AdoptionRepository adoptionRepository, OwnerRepository ownerRepository, PetRepository petRepository) {
        this.objectMapper = objectMapper;
        this.adoptionRepository = adoptionRepository;
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    @Override
    public ResponseAdoptionDTO createAdoption(RequestAdoptionDTO requestAdoptionDTO) {
        Owner owner = ownerRepository.findById(requestAdoptionDTO.getOwnerId()).orElseThrow(() -> new OwnerNotFoundException("Owner with the id" + requestAdoptionDTO.getOwnerId() + "not found"));
        Pet pet = petRepository.findById(requestAdoptionDTO.getPetId()).orElseThrow(() -> new PetNotFoundException("Pet with the id" + requestAdoptionDTO.getPetId() + "not found"));

        Adoption adoptionEntity = new Adoption();
        adoptionEntity.setOwner(owner);
        adoptionEntity.setPet(pet);
        adoptionEntity.setAdoptionDate(LocalDate.now());

        Adoption adoptionEntityResponse = adoptionRepository.save(adoptionEntity);
        log.info("Adoption with the id {} was saved", adoptionEntityResponse.getId());

        return objectMapper.convertValue(adoptionEntityResponse, ResponseAdoptionDTO.class);
    }

    @Override
    public ResponseAdoptionDTO updateAdoption(Long adoptionId, AdoptionDTO adoptionDTO) {
        Adoption existingAdoption = adoptionRepository.findById(adoptionId).orElseThrow(() -> new AdoptionNotFoundException("Adoption with the id" + adoptionId + "not found"));
    //    existingAdoption.setOwner(adoptionDTO.getOwner());
     //   existingAdoption.setPet(adoptionDTO.getPet());
        existingAdoption.setAdoptionDate(adoptionDTO.getAdoptionDate());
        existingAdoption.setStatus(adoptionDTO.getStatus());
        Adoption updatedAdoption = adoptionRepository.save(existingAdoption);
        return objectMapper.convertValue(updatedAdoption, ResponseAdoptionDTO.class);
    }

    @Override
    public AdoptionDTO getAdoptionById(Long id) {
        return adoptionRepository.findById(id)
                .map(adoption -> objectMapper.convertValue(adoption, AdoptionDTO.class))
                .orElseThrow(() -> new AdoptionNotFoundException("Adoption with the ID" + id + "not found"));

    }

    @Override
    public void deleteAdoptionById(Long id) {
        adoptionRepository.findById(id).orElseThrow(() -> new AdoptionDeleteException("Adoption with id" + id + "not found"));
        adoptionRepository.deleteById(id);
        log.info("Adoption with the id {} was deleted", id);
    }
}






