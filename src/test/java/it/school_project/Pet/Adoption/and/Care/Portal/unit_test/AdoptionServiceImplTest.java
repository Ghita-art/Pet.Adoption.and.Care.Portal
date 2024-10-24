package it.school_project.Pet.Adoption.and.Care.Portal.unit_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponsePetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.AdoptionRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.services.AdoptionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdoptionServiceImplTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private AdoptionRepository adoptionRepository;

    @InjectMocks
    private AdoptionServiceImpl adoptionService;

    @Test
    void testCreateAdoption() {
        //given
        RequestAdoptionDTO requestAdoptionDTO = new RequestAdoptionDTO();
        requestAdoptionDTO.setPetId(6L);
        requestAdoptionDTO.setOwnerId(15L);
        requestAdoptionDTO.setStatus("test status");

        ResponseAdoptionDTO responseAdoptionDTO = new ResponseAdoptionDTO();
        responseAdoptionDTO.setPet(new ResponsePetDTO());
        responseAdoptionDTO.setOwner(new ResponseOwnerDTO());
        responseAdoptionDTO.setStatus("test status");
        responseAdoptionDTO.setAdoptionDate(LocalDate.parse("2023-10-20"));

        Adoption adoptionEntity = new Adoption();
        adoptionEntity.setOwner(new Owner());
        adoptionEntity.setPet(new Pet());
        responseAdoptionDTO.setStatus("test status");
        responseAdoptionDTO.setAdoptionDate(LocalDate.parse("2023-10-20"));

        Adoption savedAdoptionEntity = new Adoption();
        savedAdoptionEntity.setId(5L);
        savedAdoptionEntity.setOwner(new Owner());
        savedAdoptionEntity.setPet(new Pet());
        savedAdoptionEntity.setStatus("test status");
        savedAdoptionEntity.setAdoptionDate(LocalDate.ofEpochDay(2023 - 10 - 20));

        when(ownerRepository.findById(requestAdoptionDTO.getOwnerId())).thenReturn(Optional.of(new Owner()));
        when(petRepository.findById(requestAdoptionDTO.getPetId())).thenReturn(Optional.of(new Pet()));
        when(adoptionRepository.save(adoptionEntity)).thenReturn(adoptionEntity);


        when(objectMapper.convertValue(any(Adoption.class), eq(ResponseAdoptionDTO.class))).thenReturn(responseAdoptionDTO);

        //when
        ResponseAdoptionDTO savedAdoptionDTO = adoptionService.createAdoption(requestAdoptionDTO);

        //then
        verify(adoptionRepository, times(1)).save(adoptionEntity);
        assertEquals(requestAdoptionDTO.getOwnerId(), savedAdoptionDTO.getOwner());
        assertEquals(requestAdoptionDTO.getPetId(), savedAdoptionDTO.getPet());
        assertEquals(requestAdoptionDTO.getStatus(), savedAdoptionDTO.getStatus());
    }
}
