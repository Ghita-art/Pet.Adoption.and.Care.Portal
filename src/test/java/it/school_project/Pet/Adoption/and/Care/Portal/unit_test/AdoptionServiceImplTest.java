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

import static org.mockito.Mockito.when;

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
        requestAdoptionDTO.setStatus("Pending");

        ResponseAdoptionDTO responseAdoptionDTO = new ResponseAdoptionDTO();
        responseAdoptionDTO.setPet(new ResponsePetDTO());
        responseAdoptionDTO.setOwner(new ResponseOwnerDTO());
        responseAdoptionDTO.setStatus("Pending");
        responseAdoptionDTO.setAdoptionDate(LocalDate.now());

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("test");
        owner.setLastName("test");
        owner.setEmail("test@gmail.com");
        owner.setPhoneNumber("421312322");
        owner.setAddress("test");

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setAge(5);
        pet.setName("test");
        pet.setType("test");
        pet.setBreed("test");
        pet.setCountry("test");
        pet.setCity("test");
        pet.setHealthStatus("test");


        Adoption adoptionEntity = new Adoption();
        adoptionEntity.setOwner(owner);
        adoptionEntity.setPet(pet);
        adoptionEntity.setStatus("Pending");
        adoptionEntity.setAdoptionDate(LocalDate.now());

        Adoption savedAdoptionEntity = new Adoption();
        savedAdoptionEntity.setId(1L);
        savedAdoptionEntity.setOwner(owner);
        savedAdoptionEntity.setPet(pet);
        savedAdoptionEntity.setStatus("Pending");
        savedAdoptionEntity.setAdoptionDate(LocalDate.now());

        when(ownerRepository.findById(requestAdoptionDTO.getOwnerId())).thenReturn(Optional.of(owner));
        when(petRepository.findById(requestAdoptionDTO.getPetId())).thenReturn(Optional.of(pet));
        when(adoptionRepository.save(adoptionEntity)).thenReturn(savedAdoptionEntity);
        when(objectMapper.convertValue(savedAdoptionEntity, ResponseAdoptionDTO.class)).thenReturn(responseAdoptionDTO);

        //when
        ResponseAdoptionDTO savedAdoptionDTO = adoptionService.createAdoption(requestAdoptionDTO);

    }
}
