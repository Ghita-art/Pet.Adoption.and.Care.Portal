package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.AdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.AdoptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class AdoptionServiceImpl implements AdoptionService {

    private final ObjectMapper objectMapper;

    private final AdoptionRepository adoptionRepository;

    public AdoptionServiceImpl(ObjectMapper objectMapper, AdoptionRepository adoptionRepository) {
        this.objectMapper = objectMapper;
        this.adoptionRepository = adoptionRepository;
    }

    @Override
    public ResponseAdoptionDTO createAdoption(RequestAdoptionDTO requestAdoptionDTO) {
        Adoption adoptionEntity = objectMapper.convertValue(requestAdoptionDTO, Adoption.class);
        Adoption adoptionEntityResponse = adoptionRepository.save(adoptionEntity);
        log.info("Adoption with the id{} was saved", adoptionEntityResponse.getId());

        return objectMapper.convertValue(adoptionEntityResponse, ResponseAdoptionDTO.class);
    }

    @Override
    public ResponseAdoptionDTO updateAdoption(Long adoptionId, Owner owner) {
        return null;
    }

    @Override
    public List<ResponseAdoptionDTO> getAdoptions(Owner owner, String status, Long id) {
        return List.of();
    }

    @Override
    public List<ResponseAdoptionDTO> searchAdoptions(String ownerName, String status, LocalDate adoptionDate, Pet pet) {
        Specification<Adoption> spec = Specification
                .where(AdoptionSpecification.ownerContains(ownerName))
                .and(AdoptionSpecification.adoptionDateIs(adoptionDate))
                .and(AdoptionSpecification.petIs(pet))
                .and(AdoptionSpecification.statusIs(status));

        List<Adoption> adoptions= adoptionRepository.findAll(spec);
        log.info("{} adoptions found", adoptions.size());

        return adoptions.stream()
                .map(adoption -> objectMapper.convertValue(adoption, ResponseAdoptionDTO.class))
                .toList();

    }
}





