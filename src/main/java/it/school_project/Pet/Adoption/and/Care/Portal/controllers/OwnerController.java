package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @PostMapping("/api/owners")
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO){
        return ResponseEntity.ok(ownerService.createOwner(ownerDTO));
    }
    @GetMapping("api/owners/{id}")
    public ResponseEntity<Optional<Owner>> getOwnerById(@PathVariable Long id){
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }
}
