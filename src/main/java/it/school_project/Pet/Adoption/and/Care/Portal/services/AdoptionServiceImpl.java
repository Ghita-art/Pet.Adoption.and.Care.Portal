package it.school_project.Pet.Adoption.and.Care.Portal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.AdoptionDeleteException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.AdoptionNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.AdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.AdoptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
        log.info("Adoption with the id {} was saved", adoptionEntityResponse.getId());

        return objectMapper.convertValue(adoptionEntityResponse, ResponseAdoptionDTO.class);
    }

    @Override
    public ResponseAdoptionDTO updateAdoption(Long adoptionId, AdoptionDTO adoptionDTO) {
        Adoption existingAdoption = adoptionRepository.findById(adoptionId).orElseThrow(() -> new AdoptionNotFoundException("Adoption with the id" + adoptionId + "not found"));
        existingAdoption.setOwner(adoptionDTO.getOwner());
        existingAdoption.setPet(adoptionDTO.getPet());
        existingAdoption.setAdoptionDate(adoptionDTO.getAdoptionDate());
        existingAdoption.setStatus(adoptionDTO.getStatus());
        Adoption updatedAdoption = adoptionRepository.save(existingAdoption);
        return objectMapper.convertValue(updatedAdoption, ResponseAdoptionDTO.class);
    }

    @Override
    public List<ResponseAdoptionDTO> getAdoptions(String ownerName, String status, Long id) {
        Specification<Adoption> spec = Specification
                .where(AdoptionSpecification.ownerContains(ownerName))
                .and(AdoptionSpecification.statusIs(status));

        List<Adoption> adoptions = adoptionRepository.findAll(spec);
        log.info("{} adoptions found", adoptions.size());

        return adoptions.stream()
                .map(adoption -> objectMapper.convertValue(adoption, ResponseAdoptionDTO.class))
                .toList();

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





