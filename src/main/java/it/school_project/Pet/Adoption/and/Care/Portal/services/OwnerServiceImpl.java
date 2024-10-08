package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.OwnerNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public OwnerDTO getOwnerById(Long id) {
        return ownerRepository.findById(id)
                .map(owner -> objectMapper.convertValue(owner, OwnerDTO.class))
                .orElseThrow(() -> new OwnerNotFoundException("Owner with the ID" + id + "not found"));
    }

    @Override
    public List<OwnerDTO> getOwners() {
        List<Owner> owners = ownerRepository.findAll();

        return owners.stream()
                .map(owner -> objectMapper.convertValue(owner, OwnerDTO.class))
                .toList();

    }

    @Override
    public OwnerDTO updateOwnerById(Long id, OwnerDTO ownerDTO) {
        if (ownerDTO == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }
        return ownerRepository.findById(id).map(existingOwner -> {
            existingOwner.setId(ownerDTO.getId());
            existingOwner.setFirstName(ownerDTO.getFirstName() != null ? ownerDTO.getFirstName() : existingOwner.getFirstName());
            existingOwner.setLastName(ownerDTO.getLastName() != null ? ownerDTO.getLastName() : existingOwner.getLastName());
            existingOwner.setAddress(ownerDTO.getAddress() != null ? ownerDTO.getAddress() : existingOwner.getAddress());
            existingOwner.setPhoneNumber(ownerDTO.getPhoneNumber() != null ? ownerDTO.getPhoneNumber() : existingOwner.getPhoneNumber());
            existingOwner.setEmail(ownerDTO.getEmail() != null ? ownerDTO.getEmail() : existingOwner.getPhoneNumber());

            Owner updateOwner = ownerRepository.save(existingOwner);
            log.info("Received OwnerDTO: {}", ownerDTO);

            return objectMapper.convertValue(updateOwner, OwnerDTO.class);
        }).orElseThrow(() -> new OwnerNotFoundException("Owner with the ID" + id + "not found"));
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }
}




