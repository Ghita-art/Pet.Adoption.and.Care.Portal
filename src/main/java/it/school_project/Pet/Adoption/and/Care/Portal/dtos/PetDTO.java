package it.school_project.Pet.Adoption.and.Care.Portal.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PetDTO {
    private Long id;

    private String name;

    private String type;

    private Integer age;

    private String city;

    private String status;
}
