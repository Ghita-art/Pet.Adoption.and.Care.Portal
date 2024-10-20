package it.school_project.Pet.Adoption.and.Care.Portal.repositories;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long>, JpaSpecificationExecutor<Adoption> {
}
