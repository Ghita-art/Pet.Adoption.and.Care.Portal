package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/api/owners")
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.ok(ownerService.createOwner(ownerDTO));
    }

    @GetMapping("api/owners/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @PutMapping("api/owners/{id}")
    public ResponseEntity<String> updateOwnerById(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO) {
        OwnerDTO updateOwnerById = ownerService.updateOwnerById(id, ownerDTO);
        return ResponseEntity.ok("Updated owner");
    }

    @DeleteMapping("api/owners/{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return ResponseEntity.ok("Owner deleted");
    }
}
