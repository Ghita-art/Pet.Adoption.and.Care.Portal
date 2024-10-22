package it.school_project.Pet.Adoption.and.Care.Portal.controllers;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestUpdatedAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseUpdatedAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.UpdatedAdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.UpdatedAdoption;
import it.school_project.Pet.Adoption.and.Care.Portal.services.UpdatedAdoptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/updated_adoptions")
public class UpdatedAdoptionController {

    private final UpdatedAdoptionService updatedAdoptionService;

    public UpdatedAdoptionController(UpdatedAdoptionService updatedAdoptionService) {
        this.updatedAdoptionService = updatedAdoptionService;
    }

    @PostMapping
    public ResponseEntity<ResponseUpdatedAdoptionDTO> createUpdatedAdoption(@RequestBody ResponseUpdatedAdoptionDTO responseUpdatedAdoptionDTO){
        return ResponseEntity.ok(updatedAdoptionService.createUpdatedAdoption(responseUpdatedAdoptionDTO));
    }
}
