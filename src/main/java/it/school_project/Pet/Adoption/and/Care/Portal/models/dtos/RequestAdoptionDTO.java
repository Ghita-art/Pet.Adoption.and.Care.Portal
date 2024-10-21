package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestAdoptionDTO {

    private Long ownerId;

    private Long petId;

    private LocalDate adoptionDate;

    private String status;
}
