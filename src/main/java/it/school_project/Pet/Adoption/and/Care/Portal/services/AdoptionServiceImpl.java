package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.AdoptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdoptionServiceImpl implements AdoptionService{

    private final ObjectMapper objectMapper;

    private final AdoptionRepository adoptionRepository;

    public AdoptionServiceImpl(ObjectMapper objectMapper, AdoptionRepository adoptionRepository) {
        this.objectMapper = objectMapper;
        this.adoptionRepository = adoptionRepository;
    }

    @Override
    public ResponseAdoptionDTO createAdoption(RequestAdoptionDTO requestAdoptionDTO) {
        return null;
    }

    @Override
    public ResponseAdoptionDTO updateAdoption(Long id, Owner owner) {
        return null;
    }

    @Override
    public List<ResponseAdoptionDTO> getAdoptions(Owner owner, String status, Long id) {
        return List.of();
    }
}
