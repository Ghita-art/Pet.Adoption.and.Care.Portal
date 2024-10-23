package it.school_project.Pet.Adoption.and.Care.Portal.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.school_project.Pet.Adoption.and.Care.Portal.models.dtos.RequestAdoptionDTO;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
public class AdoptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateAdoptionShouldPass() throws Exception {
        RequestAdoptionDTO requestAdoptionDTO = new RequestAdoptionDTO();
        requestAdoptionDTO.setOwnerId(1L);
        requestAdoptionDTO.setPetId(1L);
        requestAdoptionDTO.setAdoptionDate(LocalDate.parse("2023-10-22"));
        requestAdoptionDTO.setStatus("test status");

        mockMvc.perform(post("/api/adoptions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestAdoptionDTO)))
                .andExpect(status().isOk());
    }
}
