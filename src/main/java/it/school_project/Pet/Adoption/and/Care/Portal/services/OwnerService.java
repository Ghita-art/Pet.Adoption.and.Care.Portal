package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;

import java.util.Optional;

public interface OwnerService {
    OwnerDTO createOwner(OwnerDTO ownerDTO);

    Optional<Owner> getOwnerById(Long id);

    Optional<OwnerDTO> updateOwner(Long id, OwnerDTO ownerDTO);

    boolean deleteOwner(Long id);
}
