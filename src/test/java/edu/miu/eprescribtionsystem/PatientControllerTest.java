package edu.miu.eprescribtionsystem;

import edu.miu.eprescribtionsystem.Services.PatientService;
import edu.miu.eprescribtionsystem.controllers.PatientController;
import edu.miu.eprescribtionsystem.models.Gender;
import edu.miu.eprescribtionsystem.models.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Test
    public void testGetAllPatients() throws Exception {
        // Given
        Pageable pageable = PageRequest.of(0, 10);
         List<Patient> patients = List.of(
                new Patient(1l, "John", "Doe", Gender.MALE, "john.doe@example.com", "1234567890"),
                new Patient(2l, "Jane", "Doe", Gender.FEMALE, "jane.doe@example.com", "0987654321"),
                new Patient(3l, "Sam", "Smith", Gender.MALE, "sam.smith@example.com", "1122334455"),
                new Patient(4l, "Alice", "Johnson", Gender.FEMALE, "alice.johnson@example.com", "2233445566"),
                new Patient(5l, "Bob", "Brown", Gender.MALE, "bob.brown@example.com", "3344556677"),
                new Patient(6l, "Charlie", "Davis", Gender.MALE, "charlie.davis@example.com", "4455667788"),
                new Patient(7l, "Daisy", "Miller", Gender.FEMALE, "daisy.miller@example.com", "5566778899"),
                new Patient(8l, "Ethan", "Wilson", Gender.MALE, "ethan.wilson@example.com", "6677889900"),
                new Patient(9l, "Fiona", "Taylor", Gender.FEMALE, "fiona.taylor@example.com", "7788990011"),
                new Patient(10l, "George", "Anderson", Gender.MALE, "george.anderson@example.com", "8899001122")
        );

         Page<Patient> page = new PageImpl<>(patients, pageable, 1);
         given(patientService.findAll(pageable)).willReturn(page);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].name").value("John Doe"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value("1234567890"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").value(1));
    }
}
