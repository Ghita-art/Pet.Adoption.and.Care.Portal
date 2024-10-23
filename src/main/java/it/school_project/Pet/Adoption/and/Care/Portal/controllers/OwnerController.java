package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import io.swagger.v3.oas.annotations.Operation;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Operation(summary = "Create a new owner")
    @PostMapping
    public ResponseEntity<ResponseOwnerDTO> createOwner(@Valid @RequestBody RequestOwnerDTO requestOwnerDTO) {
        return ResponseEntity.ok(ownerService.createOwner(requestOwnerDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @Operation(summary = "Get all filtered owners by first_Name,last_Name,phone_Number,email")
    @GetMapping
    public ResponseEntity<List<ResponseOwnerDTO>> getFilteredOwners(
            @RequestParam(value = "first_name", required = false) String first_name,
            @RequestParam(value = "last_name", required = false) String last_name,
            @RequestParam(value = "phone_number", required = false) String phone_number,
            @RequestParam(value = "email", required = false) String email) {

        return ResponseEntity.ok(ownerService.getFilteredOwners(first_name, last_name, phone_number, email));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateOwnerById(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO) {
        OwnerDTO updateOwnerById = ownerService.updateOwnerById(id, ownerDTO);
        return ResponseEntity.ok("Updated owner");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return ResponseEntity.ok("Owner deleted");
    }
}
