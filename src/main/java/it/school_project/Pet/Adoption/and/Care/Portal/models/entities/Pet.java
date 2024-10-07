package it.school_project.Pet.Adoption.and.Care.Portal.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "type")
    private String type;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "status")
    private String status;

    @Column(name = "health_status")
    private String health_status;
}
