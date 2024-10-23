package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestAdoptionDTO {

    @NotNull(message = "The owner ID is required")
    private Long ownerId;

    @NotNull(message = "The pet ID is required")
    private Long petId;

    @NotNull(message = "The adoption date is required")
    private LocalDate adoptionDate;

    @NotBlank(message = "The status is required")
    private String status;
}
