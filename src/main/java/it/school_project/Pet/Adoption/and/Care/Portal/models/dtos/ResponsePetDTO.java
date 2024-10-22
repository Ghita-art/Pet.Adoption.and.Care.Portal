package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponsePetDTO {

    private Long id;

    private String name;

    private String breed;

    private String type;

    private String gender;

    private Integer age;

    private String country;

    private String city;

    private String status;

    private String healthStatus;
}
