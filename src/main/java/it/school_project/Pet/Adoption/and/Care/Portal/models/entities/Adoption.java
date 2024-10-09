package it.school_project.Pet.Adoption.and.Care.Portal.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "adoptions")
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The owner is required")
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @NotNull(message = "The pet is required")
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @NotNull(message = "The adoption date is required")
    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

    @NotNull(message = "The status is required")
    @Column(name = "status")
    private String status;
}
