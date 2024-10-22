package it.school_project.Pet.Adoption.and.Care.Portal.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestUpdatedAdoptionDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase

public class UpdatedAdoptionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUpdatedAdoptionShouldPass() throws Exception{
        RequestUpdatedAdoptionDTO requestUpdatedAdoptionDTO = new RequestUpdatedAdoptionDTO();
        requestUpdatedAdoptionDTO.setOwnerId(3L);
        requestUpdatedAdoptionDTO.setPetId(4L);
        requestUpdatedAdoptionDTO.setStatus("test status");

        mockMvc.perform(post("/api/updated_adoptions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestUpdatedAdoptionDTO)))
                .andExpect(status().isOk());
    }
}
