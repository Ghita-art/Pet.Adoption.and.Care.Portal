package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class OwnerServiceImpl implements OwnerService {

    private final ObjectMapper objectMapper;

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(ObjectMapper objectMapper, OwnerRepository ownerRepository) {
        this.objectMapper = objectMapper;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner ownerEntity = objectMapper.convertValue(ownerDTO, Owner.class);
        Owner ownerEntityResponse = ownerRepository.save(ownerEntity);
        log.info("Owner with id {} was saved", ownerEntityResponse.getId());
        return objectMapper.convertValue(ownerEntityResponse, OwnerDTO.class);
    }

    @Override
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Optional<OwnerDTO> updateOwner(Long id, OwnerDTO ownerDTO) {
        return ownerRepository.findById(id).map(existingowner -> {
            existingowner.setId(ownerDTO.getId());
            existingowner.setFirstName(ownerDTO.getFirstName());
            existingowner.setLastName(ownerDTO.getLastName());
            existingowner.setAddress(ownerDTO.getAddress());
            existingowner.setPhoneNumber(ownerDTO.getPhoneNumber());
            existingowner.setEmail(ownerDTO.getEmail());

            Owner updateowner = ownerRepository.save(existingowner);
            return objectMapper.convertValue(updateowner, OwnerDTO.class);
        });
    }

    @Override
    public boolean deleteOwner(Long id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

