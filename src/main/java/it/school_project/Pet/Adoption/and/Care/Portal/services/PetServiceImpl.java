package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PetServiceImpl implements PetServices {

    private final ObjectMapper objectMapper;

    private final PetRepository petRepository;

    public PetServiceImpl(ObjectMapper objectMapper, PetRepository petRepository) {
        this.objectMapper = objectMapper;
        this.petRepository = petRepository;
    }

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        Pet petEntity = objectMapper.convertValue(petDTO, Pet.class);
        Pet petEntityResponse = petRepository.save(petEntity);
        log.info("Pet with id {} was saved", petEntityResponse.getId());


        return objectMapper.convertValue(petEntityResponse, PetDTO.class);
    }
}
