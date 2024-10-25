package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.AdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.services.AdoptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/adoptions")
@RestController
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @PostMapping
    public ResponseEntity<ResponseAdoptionDTO> createAdoption(@RequestBody RequestAdoptionDTO requestAdoptionDTO) {
        return ResponseEntity.ok(adoptionService.createAdoption(requestAdoptionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdoptionById(@PathVariable Long id, @RequestBody AdoptionDTO adoptionDTO) {
        ResponseAdoptionDTO updateAdoptionById = adoptionService.updateAdoption(id, adoptionDTO);
        return ResponseEntity.ok("Updated adoption");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionDTO> getAdoptionById(@PathVariable Long id) {
        return ResponseEntity.ok(adoptionService.getAdoptionById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdoptionById(@PathVariable Long id) {
        adoptionService.deleteAdoptionById(id);
        return ResponseEntity.ok("Adoption deleted");
    }
}
