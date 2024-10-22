package it.school_project.Pet.Adoption.and.Care.Portal.unit_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.OwnerNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.exceptions.PetNotFoundException;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestUpdatedAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseUpdatedAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.UpdatedAdoption;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.UpdatedAdoptionRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.services.UpdatedAdoptionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class UpdatedAdoptionServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private UpdatedAdoptionRepository updatedAdoptionRepository;

    @InjectMocks
    private UpdatedAdoptionServiceImpl updatedAdoptionService;

    @AfterAll
    public static void test() {

    }

    @Test
    void testCreateUpdatedAdoption() {
        // Given
        Owner mockOwner = new Owner();
        mockOwner.setId(5L);
        mockOwner.setFirstName("Mock Owner");

        Pet mockPet = new Pet();
        mockPet.setId(6L);
        mockPet.setName("Mock Pet");

        RequestUpdatedAdoptionDTO requestUpdatedAdoptionDTO = new RequestUpdatedAdoptionDTO();
        requestUpdatedAdoptionDTO.setOwner(mockOwner);
        requestUpdatedAdoptionDTO.setPet(mockPet);
        requestUpdatedAdoptionDTO.setStatus("test status");

        ResponseUpdatedAdoptionDTO responseUpdatedAdoptionDTO = new ResponseUpdatedAdoptionDTO();
        responseUpdatedAdoptionDTO.setOwner(mockOwner);
        responseUpdatedAdoptionDTO.setPet(mockPet);
        responseUpdatedAdoptionDTO.setStatus("test status");

        UpdatedAdoption updatedAdoptionEntity = new UpdatedAdoption();
        updatedAdoptionEntity.setOwner(mockOwner);
        updatedAdoptionEntity.setPet(mockPet);
        updatedAdoptionEntity.setStatus("test status");

        lenient().when(objectMapper.convertValue(any(ResponseUpdatedAdoptionDTO.class), eq(UpdatedAdoption.class)))
                .thenReturn(updatedAdoptionEntity);
        when(updatedAdoptionRepository.save(any(UpdatedAdoption.class))).thenReturn(updatedAdoptionEntity);
        when(objectMapper.convertValue(any(UpdatedAdoption.class), eq(ResponseUpdatedAdoptionDTO.class)))
                .thenReturn(responseUpdatedAdoptionDTO);

        // When
        ResponseUpdatedAdoptionDTO savedUpdatedAdoptionDTO = updatedAdoptionService.createUpdatedAdoption(responseUpdatedAdoptionDTO);

        // Then
        assertNotNull(savedUpdatedAdoptionDTO);
        assertEquals(savedUpdatedAdoptionDTO.getPet().getId(), mockPet.getId());
        assertEquals(savedUpdatedAdoptionDTO.getOwner().getId(), mockOwner.getId());
        assertEquals(savedUpdatedAdoptionDTO.getStatus(), "test status");
    }
}
