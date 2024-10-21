package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.OwnerDuplicateEmailException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.OwnerNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseOwnerDTO createOwner(RequestOwnerDTO requestOwnerDTO) {
        validateEmailAddress(requestOwnerDTO);

        Owner ownerEntity = objectMapper.convertValue(requestOwnerDTO, Owner.class);
        Owner ownerEntityResponse = ownerRepository.save(ownerEntity);
        log.info("Owner with id {} was saved", ownerEntityResponse.getId());

        return objectMapper.convertValue(ownerEntityResponse, ResponseOwnerDTO.class);
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
    public List<ResponseOwnerDTO> getFilteredOwners(String firstName, String lastName, String phoneNumber, String email) {
        Specification<Owner> spec = Specification
                .where(OwnerSpecification.firstNameContains(firstName))
                .and(OwnerSpecification.lastNameContains(lastName))
                .and(OwnerSpecification.phoneNumberContains(phoneNumber))
                .and(OwnerSpecification.emailContains(email));

        List<Owner> owners = ownerRepository.findAll(spec);
        log.info("{} owners found", owners.size());

        return owners.stream()
                .map(owner -> objectMapper.convertValue(owner, ResponseOwnerDTO.class))
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
        ownerRepository.findById(id).orElseThrow(() -> new OwnerNotFoundException("Owner with the id " + id + "not found"));
        ownerRepository.deleteById(id);
        log.info("Owner with the id {} was deleted", id);
    }

    private void validateEmailAddress(RequestOwnerDTO requestOwnerDTO) {
        Owner owner = ownerRepository.findByEmail(requestOwnerDTO.getEmail());
        if (owner != null) {
            throw new OwnerDuplicateEmailException("The email address already exists");
        }
    }
}




