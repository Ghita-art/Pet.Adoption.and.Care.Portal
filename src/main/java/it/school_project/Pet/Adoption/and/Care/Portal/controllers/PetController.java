package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.services.PetServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    private final PetServices petServices;

    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }
    @PostMapping("/api/pets")
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO petDTO){
        return ResponseEntity.ok(petServices.createPet(petDTO));
    }
}

