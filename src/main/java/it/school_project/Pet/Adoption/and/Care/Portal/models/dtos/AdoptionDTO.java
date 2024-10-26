package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdoptionDTO {

    @NotNull(message = "The id is required")
    private Long id;

    @NotNull(message = "The owner is required")
    private ResponseOwnerDTO owner;

    @NotNull(message = "The pet is required")
    private ResponsePetDTO pet;

    @NotNull(message = "The adoption date is required")
    @FutureOrPresent(message = "The adoption date cannot be in the past")
    private LocalDate adoptionDate;

   // @NotNull(message = "The status is required")
   // @Pattern(regexp = "pending|completed|rejected", message = "Invalid status")
    private String status;
}

