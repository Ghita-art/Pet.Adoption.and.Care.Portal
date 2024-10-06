package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PetDTO {
    private Long id;

    private String name;

    private String breed;

    private String type;

    private Integer age;

    private String country;

    private String city;

    private String status;
}
