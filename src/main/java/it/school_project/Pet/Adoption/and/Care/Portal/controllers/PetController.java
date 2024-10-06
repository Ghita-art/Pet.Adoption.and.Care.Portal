package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.services.PetServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Optional<Pet>> getPetById(@PathVariable Long id){
        return ResponseEntity.ok(petServices.getPetById(id));
    }
}








