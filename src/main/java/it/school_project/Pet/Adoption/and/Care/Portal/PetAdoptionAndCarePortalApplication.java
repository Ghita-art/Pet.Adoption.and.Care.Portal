package it.school_project.Pet.Adoption.and.Care.Portal;

import it.school_project.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import it.school_project.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetAdoptionAndCarePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetAdoptionAndCarePortalApplication.class, args);
    }
}

