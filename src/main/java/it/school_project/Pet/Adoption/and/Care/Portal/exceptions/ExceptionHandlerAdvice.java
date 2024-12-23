package it.school_project.Pet.Adoption.and.Care.Portal.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {
    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<String> ownerCreateException(OwnerCreateException ownerCreateException) {
        return new ResponseEntity<>(objectToString(Map.of("message", ownerCreateException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<String> petCreateException(PetCreateException petCreateException) {
        return new ResponseEntity<>(objectToString(Map.of("message", petCreateException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(AdoptionNotFoundException.class)
    public ResponseEntity<String> adoptionCreateException(AdoptionNotFoundException adoptionNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", adoptionNotFoundException.getMessage())), NOT_FOUND);
    }

    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);

        } catch (JsonProcessingException e) {
            log.error("Error processing response to string");
            return "Internal error";
        }
    }
}
