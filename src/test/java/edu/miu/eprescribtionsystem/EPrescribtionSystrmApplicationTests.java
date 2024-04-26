package edu.miu.eprescribtionsystem;
import edu.miu.eprescribtionsystem.models.Patient;
import edu.miu.eprescribtionsystem.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import  org.springframework.test.web.servlet.*;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = EPrescribtionSystrmApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class EPrescribtionSystrmApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PatientRepository repository;

    @Test
    public void givenPatients_whenGetPatients_thenStatus200()
            throws Exception {



    }

    @Test
    public void testStatus(){
        assertTrue(repository.findById(1l).isPresent());
    }

}
