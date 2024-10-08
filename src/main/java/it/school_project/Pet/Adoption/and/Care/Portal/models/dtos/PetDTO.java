package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetDTO {
    @NotNull(message = "The id is required")
    private Long id;

    @NotNull(message = "The name is required")
    private String name;

    @NotNull(message = "The breed is required")
    private String breed;

    @NotNull(message = "The type is required")
    private String type;

    @NotNull(message = "The gender is required")
    private String gender;

    @NotNull(message = "The age is required")
    private Integer age;

    @NotNull(message = "The country is required")
    private String country;

    @NotNull(message = "The city is required")
    private String city;

    @NotNull(message = "The status is required")
    private String status;

    @NotNull(message = "The health_status is required")
    private String healthStatus;

}
