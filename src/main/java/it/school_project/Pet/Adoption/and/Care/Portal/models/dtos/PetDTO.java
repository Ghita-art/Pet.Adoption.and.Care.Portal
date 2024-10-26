package it.school_project.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PetDTO {

    private Long id;

    @NotNull(message = "The pet name is required")
    @Size(max = 50, message = "The pet name must be less than 50 characters")
    private String name;

    @NotNull(message = "The breed is required")
    @Size(max = 50, message = "The breed must be less than 50 characters")
    private String breed;

    @NotNull(message = "The type is required")
    @Size(max = 30, message = "The type must be less than 30 characters")
    private String type;

    @NotNull(message = "The gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be either 'Male' or 'Female'")
    private String gender;

    @NotNull(message = "The age is required")
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 30, message = "Age cannot exceed 30 years")
    private Integer age;

    @NotNull(message = "The country is required")
    @Size(max = 50, message = "The country name must be less than 50 characters")
    private String country;

    @NotNull(message = "The city is required")
    @Size(max = 50, message = "The city name must be less than 50 characters")
    private String city;

   // @NotNull(message = "The status is required")
   // @Pattern(regexp = "Available|Adopted|Pending", message = "Invalid status")
  //  private String status;

    @NotNull(message = "The health status is required")
    @Size(max = 100, message = "The health status must be less than 100 characters")
    private String healthStatus;

}
