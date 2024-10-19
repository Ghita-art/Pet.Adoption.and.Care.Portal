package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.AdoptionDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class AdoptionSpecification {
    public static Specification<Adoption> ownerContains(String ownerName) {
        return (root, query, criteriaBuilder) -> {
            if (ownerName != null && !ownerName.isEmpty()) {
                Join<Adoption, Owner> ownerJoin = root.join("owner");
                return criteriaBuilder.like(criteriaBuilder.lower(ownerJoin.get("name")), "%" + ownerName.toLowerCase() + "%");
            }
            return null;
        };
    }

    public static Specification<Adoption> statusIs(String status) {
        return (root, query, criteriaBuilder) -> {
            if (status != null && !status.isEmpty()) {
                return criteriaBuilder.equal(root.get("status"), status);
            }
            return null;
        };
    }

    public static Specification<Adoption> adoptionDateIs(LocalDate adoptionDate) {
        return (root, query, criteriaBuilder) -> {
            if (adoptionDate != null) {
                return criteriaBuilder.equal(root.get("adoptionDate"), adoptionDate);
            }
            return null;
        };
    }

    public static Specification<Adoption> petIs(Pet pet) {
        return (root, query, criteriaBuilder) -> {
            if (pet != null) {
                Join<Adoption, Pet> petJoin = root.join("pet");
                return criteriaBuilder.equal(petJoin, pet);
            }
            return null;
        };
    }
}
