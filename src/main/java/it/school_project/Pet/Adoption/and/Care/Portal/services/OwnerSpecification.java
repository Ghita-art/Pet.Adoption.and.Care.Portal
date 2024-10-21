package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import org.springframework.data.jpa.domain.Specification;

public class OwnerSpecification {
    // firstName, lastName, phoneNumber, email

    public static Specification<Owner> firstNameContains(String firstName) {
        return (owner, query, criteriaBuilder) -> firstName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(owner.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Owner> lastNameContains(String lastName) {
        return (owner, query, criteriaBuilder) -> lastName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(owner.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<Owner> phoneNumberContains(String phoneNumber) {
        return (owner, query, criteriaBuilder) -> phoneNumber == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(owner.get("phoneNumber")), "%" + phoneNumber.toLowerCase() + "%");
    }

    public static Specification<Owner> emailContains(String email) {
        return (owner, query, criteriaBuilder) -> email == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(owner.get("email")), "%" + email.toLowerCase() + "%");
    }
}
