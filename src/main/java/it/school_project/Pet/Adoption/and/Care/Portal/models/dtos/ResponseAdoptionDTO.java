package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseAdoptionDTO {

    private Long id;
    private ResponseOwnerDTO owner;
    private ResponsePetDTO pet;
    private LocalDate adoptionDate;
    private String status;
}