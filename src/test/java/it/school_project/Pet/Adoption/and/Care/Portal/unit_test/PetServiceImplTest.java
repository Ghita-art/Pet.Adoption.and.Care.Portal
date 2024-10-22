package it.school_project.Pet.Adoption.and.Care.Portal.unit_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestPetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponsePetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import it.school_project.Pet.Adoption.and.Care.Portal.services.PetServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class PetServiceImplTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @AfterAll
    public static void test() {
    }

    @Test
    void testCreatePet() {
        //given
        RequestPetDTO requestPetDTO = new RequestPetDTO();
        requestPetDTO.setId(4L);
        requestPetDTO.setName("test name");
        requestPetDTO.setGender("test gender");
        requestPetDTO.setBreed("test breed");
        requestPetDTO.setAge(Integer.valueOf("5"));
        requestPetDTO.setCity("test city");
        requestPetDTO.setType("test type");
        requestPetDTO.setCountry("test country");

        ResponsePetDTO responsePetDTO = new ResponsePetDTO();
        responsePetDTO.setId(4L);
        responsePetDTO.setName("test name");
        responsePetDTO.setGender("test gender");
        responsePetDTO.setBreed("test breed");
        responsePetDTO.setAge(Integer.valueOf("5"));
        responsePetDTO.setCity("test city");
        responsePetDTO.setType("test type");
        responsePetDTO.setCountry("test country");

        Pet petEntity = new Pet();
        petEntity.setId(4L);
        petEntity.setName("test name");
        petEntity.setGender("test gender");
        petEntity.setBreed("test breed");
        petEntity.setAge(Integer.valueOf("5"));
        petEntity.setCity("test city");
        petEntity.setType("test type");
        petEntity.setCountry("test country");

        Pet savedPetEntity = new Pet();
        savedPetEntity.setName("test name");
        savedPetEntity.setGender("test gender");
        savedPetEntity.setBreed("test breed");
        savedPetEntity.setAge(Integer.valueOf("5"));
        savedPetEntity.setCity("test city");
        savedPetEntity.setType("test type");
        savedPetEntity.setCountry("test country");


        when(objectMapper.convertValue(requestPetDTO, Pet.class)).thenReturn(petEntity);
        when(petRepository.save(petEntity)).thenReturn(petEntity);
        when(objectMapper.convertValue(any(Pet.class), eq(ResponsePetDTO.class))).thenReturn(responsePetDTO);

        //when
        ResponsePetDTO savedPetDTO = petService.createPet(requestPetDTO);

        //then
        verify(petRepository, times(1)).save(petEntity);
        assertEquals(requestPetDTO.getName(), savedPetDTO.getName());
        assertEquals(requestPetDTO.getGender(), savedPetDTO.getGender());
        assertEquals(requestPetDTO.getCountry(), savedPetDTO.getCountry());
        assertEquals(requestPetDTO.getCity(), savedPetDTO.getCity());
        assertEquals(requestPetDTO.getBreed(), savedPetDTO.getBreed());
        assertEquals(requestPetDTO.getAge(), savedPetDTO.getAge());
        assertEquals(requestPetDTO.getStatus(), savedPetDTO.getStatus());
        assertEquals(requestPetDTO.getType(), savedPetDTO.getType());
        assertEquals(requestPetDTO.getHealthStatus(), savedPetDTO.getHealthStatus());
    }
}


