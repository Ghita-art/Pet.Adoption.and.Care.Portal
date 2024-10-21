package it.school_project.Pet.Adoption.and.Care.Portal.unit_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.OwnerRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.services.OwnerServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class OwnerServiceImplTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @AfterAll
    public static void test() {
    }

    @Test
    void testCreateOwner() {
        //given
        RequestOwnerDTO requestOwnerDTO = new RequestOwnerDTO();
        requestOwnerDTO.setFirstName("test firstName");
        requestOwnerDTO.setLastName("test lastName");
        requestOwnerDTO.setAddress("test address");
        requestOwnerDTO.setPhoneNumber("215485254568");
        requestOwnerDTO.setEmail("test@example.com");

        ResponseOwnerDTO responseOwnerDTO = new ResponseOwnerDTO();
        responseOwnerDTO.setFirstName("test firstName");
        responseOwnerDTO.setLastName("test lastName");
        responseOwnerDTO.setAddress("test address");
        responseOwnerDTO.setPhoneNumber("215485254568");
        responseOwnerDTO.setEmail("test@example.com");

        Owner ownerEntity = new Owner();
        ownerEntity.setFirstName("test firstName");
        ownerEntity.setLastName("test lastName");
        ownerEntity.setAddress("test address");
        ownerEntity.setPhoneNumber("215485254568");
        ownerEntity.setEmail("test@example.com");

        Owner savedOwnerEntity = new Owner();
        savedOwnerEntity.setFirstName("test firstName");
        savedOwnerEntity.setLastName("test lastName");
        savedOwnerEntity.setAddress("test address");
        savedOwnerEntity.setPhoneNumber("215485254568");
        savedOwnerEntity.setEmail("test@example.com");

        when(objectMapper.convertValue(requestOwnerDTO, Owner.class)).thenReturn(ownerEntity);
        when(ownerRepository.save(ownerEntity)).thenReturn(ownerEntity);
        when(objectMapper.convertValue(savedOwnerEntity, ResponseOwnerDTO.class)).thenReturn(responseOwnerDTO);

        //when
        ResponseOwnerDTO savedOwnerDTO = ownerService.createOwner(requestOwnerDTO);

        //then
        verify(ownerRepository, times(1)).save(ownerEntity);
        assertEquals(requestOwnerDTO.getFirstName(), savedOwnerDTO.getFirstName());
        assertEquals(requestOwnerDTO.getLastName(), savedOwnerDTO.getLastName());
        assertEquals(requestOwnerDTO.getAddress(), savedOwnerDTO.getAddress());
        assertEquals(requestOwnerDTO.getPhoneNumber(), savedOwnerDTO.getPhoneNumber());
        assertEquals(requestOwnerDTO.getEmail(), savedOwnerDTO.getEmail());
    }
}
