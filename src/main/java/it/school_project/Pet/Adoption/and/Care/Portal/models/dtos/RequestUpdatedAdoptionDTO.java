package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestUpdatedAdoptionDTO {

    @NotNull(message = "The pet is required")
    private Long petId;

    @NotNull(message = "The owner is required")
    private  Long ownerId;

    @NotNull(message = "The status is required")
    private String status;

    @NotNull(message = "The owner is required")
    private Owner owner;

    @NotNull(message = "The pet is required")
    private Pet pet;

}
