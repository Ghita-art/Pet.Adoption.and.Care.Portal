package it.school_project.Pet.Adoption.and.Care.Portal.services;

import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.OwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestOwnerDTO;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.ResponseOwnerDTO;

import java.util.List;

public interface OwnerService {


    ResponseOwnerDTO createOwner(RequestOwnerDTO requestOwnerDTO);

    OwnerDTO getOwnerById(Long id);

    OwnerDTO updateOwnerById(Long id, OwnerDTO ownerDTO);

    void deleteOwnerById(Long id);

    List<OwnerDTO> getOwners();

    List<ResponseOwnerDTO> getFilteredOwners(String firstName, String lastName, String phoneNumber, String email);
}
