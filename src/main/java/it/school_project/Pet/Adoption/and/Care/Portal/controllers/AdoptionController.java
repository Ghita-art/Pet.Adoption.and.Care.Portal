package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.services.AdoptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/adoptions")
@RestController
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseAdoptionDTO>> getAdoptions(
            @RequestParam(value = "owner", required = false) Owner owner,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "id", required = false) Long id) {
        return ResponseEntity.ok(adoptionService.getAdoptions(owner, status, id));
    }

    @PostMapping
    public ResponseEntity<ResponseAdoptionDTO> createAdoption(@RequestBody RequestAdoptionDTO requestAdoptionDTO) {
        return ResponseEntity.ok(adoptionService.createAdoption(requestAdoptionDTO));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseAdoptionDTO> updateAdoption(@PathVariable Long id,@RequestBody RequestAdoptionDTO requestAdoptionDTO){
        return ResponseEntity.ok(adoptionService.updateAdoption(id, requestAdoptionDTO.getOwner()));
    }
}
