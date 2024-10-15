package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestAdoptionDTO {

    private Owner owner;

    private Pet pet;

    private LocalDate adoptionDate;

    private String status;
}
