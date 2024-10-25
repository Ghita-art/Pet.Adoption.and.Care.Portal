package it.school_project.Pet.Adoption.and.Care.Portal.models.entities;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.PetDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The first name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "The last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "The address is required")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Phone number is required")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull(message = "Email is required")
    @Column(name = "email")
    private String email;

   @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets;

}
