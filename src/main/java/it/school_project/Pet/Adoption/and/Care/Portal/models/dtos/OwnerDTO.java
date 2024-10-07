package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OwnerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;
}
