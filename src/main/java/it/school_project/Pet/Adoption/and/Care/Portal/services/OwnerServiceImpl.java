package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
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
}
