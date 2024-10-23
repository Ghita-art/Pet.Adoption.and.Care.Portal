package it.school_project.Pet.Adoption.and.Care.Portal.repositories;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>, JpaSpecificationExecutor<Owner> {
    Owner findByEmail(String email);
}
