package it.school_project.Pet.Adoption.and.Care.Portal.unit_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.AdoptionRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.services.AdoptionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdoptionServiceImplTest {
    @Mock
    private ObjectMapper objectMapper;

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
        requestAdoptionDTO.setAdoptionDate(LocalDate.parse("2023-10-20"));

        ResponseAdoptionDTO responseAdoptionDTO = new ResponseAdoptionDTO();
        responseAdoptionDTO.setPetId(6L);
        responseAdoptionDTO.setOwnerId(15L);
        responseAdoptionDTO.setStatus("test status");
        responseAdoptionDTO.setAdoptionDate(LocalDate.parse("2023-10-20"));

        Adoption adoptionEntity = new Adoption();
        adoptionEntity.setOwner(new Owner());
        adoptionEntity.setPet(new Pet());
        responseAdoptionDTO.setStatus("test status");
        responseAdoptionDTO.setAdoptionDate(LocalDate.parse("2023-10-20"));

        Adoption savedAdoptionEntity = new Adoption();
        savedAdoptionEntity.setOwner(new Owner());
        savedAdoptionEntity.setPet(new Pet());
        savedAdoptionEntity.setId((long) 5L);
        savedAdoptionEntity.setStatus("test status");
        savedAdoptionEntity.setAdoptionDate(LocalDate.ofEpochDay(2023 - 10 - 20));

        when(objectMapper.convertValue(requestAdoptionDTO, Adoption.class)).thenReturn(adoptionEntity);
        when(adoptionRepository.save(adoptionEntity)).thenReturn(adoptionEntity);
        when(objectMapper.convertValue(any(Adoption.class), eq(ResponseAdoptionDTO.class))).thenReturn(responseAdoptionDTO);

        //when
        ResponseAdoptionDTO savedAdoptionDTO = adoptionService.createAdoption(requestAdoptionDTO);

        //then
        verify(adoptionRepository, times(1)).save(adoptionEntity);
        assertEquals(requestAdoptionDTO.getOwnerId(), savedAdoptionDTO.getOwnerId());
        assertEquals(requestAdoptionDTO.getPetId(), savedAdoptionDTO.getPetId());
        assertEquals(requestAdoptionDTO.getAdoptionDate(), savedAdoptionDTO.getAdoptionDate());
        assertEquals(requestAdoptionDTO.getStatus(), savedAdoptionDTO.getStatus());
    }
}
