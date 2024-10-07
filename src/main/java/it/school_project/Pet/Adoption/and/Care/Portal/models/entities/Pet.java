package it.school_project.Pet.Adoption.and.Care.Portal.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name is required")
    @Column(name = "name")
    private String name;

    @NotNull(message = "The breed is required")
    @Column(name = "breed")
    private String breed;

    @NotNull(message = "The type is required")
    @Column(name = "type")
    private String type;

    @NotNull(message = "The gender is required")
    @Column(name = "gender")
    private String gender;

    @NotNull(message = "The age is required")
    @Column(name = "age")
    private Integer age;

    @NotNull(message = "The country is required")
    @Column(name = "country")
    private String country;

    @NotNull(message = "The city is required")
    @Column(name = "city")
    private String city;

    @NotNull(message = "The status is required")
    @Column(name = "status")
    private String status;

    @NotNull(message = "The health_status is required")
    @Column(name = "health_status")
    private String health_status;
}
