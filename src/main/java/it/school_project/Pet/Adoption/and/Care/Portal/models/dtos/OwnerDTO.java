package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OwnerDTO {

    @NotNull(message = "The id is required")
    private Long id;

    @NotNull(message = "The first name is required")
    private String firstName;

    @NotNull(message = "The last name is required")
    private String lastName;

    @NotNull(message = "The address is required")
    private String address;

    @NotNull(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Email is required")
    private String email;

}
