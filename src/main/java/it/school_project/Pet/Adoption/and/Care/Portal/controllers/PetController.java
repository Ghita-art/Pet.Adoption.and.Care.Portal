package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import io.swagger.v3.oas.annotations.Operation;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestPetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponsePetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.services.PetServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetServices petServices;

    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }

    @Operation(summary = "Create a new pet")
    @PostMapping
    public ResponseEntity<ResponsePetDTO> createPet(@Valid @RequestBody RequestPetDTO requestPetDTO) {
        return ResponseEntity.ok(petServices.createPet(requestPetDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petServices.getPetById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updatePetById(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        PetDTO updatedPetById = petServices.updatePetById(id, petDTO);
        return ResponseEntity.ok("Updated pet");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePetById(@PathVariable Long id) {
        petServices.deletePetById(id);
        return ResponseEntity.ok("Pet deleted");
    }
}









