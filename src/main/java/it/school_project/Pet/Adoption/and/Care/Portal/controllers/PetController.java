package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.services.PetServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.Optional;

@Slf4j
@RestController
public class PetController {
    private final PetServices petServices;

    @Autowired
    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }

    @PostMapping("/api/pets")
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petServices.createPet(petDTO));
    }

    @GetMapping("api/pets/{id}")
    public ResponseEntity<Optional<Pet>> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petServices.getPetById(id));
    }

    @PutMapping("api/pets/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        log.info("Received PetDTO: {}", petDTO);
        Optional<PetDTO> updatedPet = petServices.updatePet(id, petDTO);
        return updatedPet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("api/pets/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        boolean isDeleted = petServices.deletePet(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}








