package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.PetNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestPetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponsePetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponsePetDTO createPet(RequestPetDTO requestPetDTO) {
        Pet petEntity = objectMapper.convertValue(requestPetDTO, Pet.class);
        Pet petEntityResponse = petRepository.save(petEntity);
        log.info("Pet with id {} was saved", petEntityResponse.getId());

        return objectMapper.convertValue(petEntityResponse, ResponsePetDTO.class);
    }

    @Override
    public List<PetDTO> getPets() {
        List<Pet> pets = petRepository.findAll();

        return pets.stream()
                .map(pet -> objectMapper.convertValue(pet, PetDTO.class))
                .toList();
    }

    @Override
    public PetDTO getPetById(Long id) {
        return petRepository.findById(id)
                .map(pet -> objectMapper.convertValue(pet, PetDTO.class))
                .orElseThrow(() -> new PetNotFoundException("Pet with ID" + id + "not found"));
    }

    @Override
    public PetDTO updatePetById(Long id, PetDTO petDTO) {
        if (petDTO == null) {
            throw new IllegalArgumentException("PetDTO cannot be null");
        }
        return petRepository.findById(id).map(existingPet -> {
            existingPet.setName(petDTO.getName() != null ? petDTO.getName() : existingPet.getName());
            existingPet.setAge(petDTO.getAge() != null ? petDTO.getAge() : existingPet.getAge());
            existingPet.setBreed(petDTO.getBreed() != null ? petDTO.getBreed() : existingPet.getBreed());
            existingPet.setType(petDTO.getType() != null ? petDTO.getType() : existingPet.getType());
            existingPet.setStatus(petDTO.getStatus() != null ? petDTO.getStatus() : existingPet.getStatus());
            existingPet.setCountry(petDTO.getCountry() != null ? petDTO.getCountry() : existingPet.getCountry());
            existingPet.setCity(petDTO.getCity() != null ? petDTO.getCity() : existingPet.getCity());

            Pet updatedPet = petRepository.save(existingPet);
            log.info("Updated PetDTO: {}", petDTO);

            return objectMapper.convertValue(updatedPet, PetDTO.class);
        }).orElseThrow(() -> new PetNotFoundException("Pet with ID " + id + " not found"));
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet wit the id" + id + "not found"));
        petRepository.deleteById(id);
        log.info("Pet with the id {} was deleted", id);
    }
}

















