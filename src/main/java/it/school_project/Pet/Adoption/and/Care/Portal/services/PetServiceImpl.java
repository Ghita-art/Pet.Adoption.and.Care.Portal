package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public Optional<PetDTO> updatePet(Long id, PetDTO petDTO) {
        return petRepository.findById(id).map(existingPet -> {
            existingPet.setId(petDTO.getId());
            existingPet.setName(petDTO.getName());
            existingPet.setAge(petDTO.getAge());
            existingPet.setBreed(petDTO.getBreed());
            existingPet.setType(petDTO.getType());
            existingPet.setStatus(petDTO.getStatus());
            existingPet.setCountry(petDTO.getCountry());
            existingPet.setCity(petDTO.getCity());

            Pet updatePet = petRepository.save(existingPet);
            return objectMapper.convertValue(updatePet, PetDTO.class);
        });
    }

    @Override
    public boolean deletePet(Long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}











