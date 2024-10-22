package it.school_project.Pet.Adoption.and.Care.Portal.repositories;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.UpdatedAdoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatedAdoptionRepository extends JpaRepository<UpdatedAdoption, Long> {
}
