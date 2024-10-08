package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    OwnerDTO createOwner(OwnerDTO ownerDTO);

    OwnerDTO getOwnerById(Long id);

   OwnerDTO updateOwnerById(Long id, OwnerDTO ownerDTO);

    void deleteOwnerById(Long id);

    List<OwnerDTO> getOwners();
}
