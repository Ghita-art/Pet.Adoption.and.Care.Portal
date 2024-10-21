package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseOwnerDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String email;
}
