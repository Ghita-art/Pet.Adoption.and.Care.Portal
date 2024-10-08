package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.services.PetServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PetController {
    private final PetServices petServices;

    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }

    @PostMapping("/api/pets")
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petServices.createPet(petDTO));
    }

    @GetMapping("api/pets/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petServices.getPetById(id));
    }

    @PutMapping("api/pets/{id}")
    public ResponseEntity<String> updatePetById(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        PetDTO updatedPetById = petServices.updatePetById(id, petDTO);
        return ResponseEntity.ok("Updated pet");
    }

    @DeleteMapping("api/pets/{id}")
    public ResponseEntity<String> deletePetById(@PathVariable Long id) {
        petServices.deletePetById(id);
        return ResponseEntity.ok("Pet deleted");

    }
}









