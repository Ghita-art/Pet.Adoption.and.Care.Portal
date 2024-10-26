package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RequestAdoptionDTO {

    @NotNull(message = "The owner id is required")
    private Long ownerId;

    @NotNull(message = "The pet id is required")
    private Long petId;

    @NotNull(message = "The status is required")
    @Pattern(regexp = "Pending|Completed|Rejected", message = "Invalid status value")
    private String status;
}
