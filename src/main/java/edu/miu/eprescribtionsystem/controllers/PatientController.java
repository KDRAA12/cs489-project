package edu.miu.eprescribtionsystem.controllers;


import edu.miu.eprescribtionsystem.Services.PatientService;
import edu.miu.eprescribtionsystem.dtos.PatientDTO;
import edu.miu.eprescribtionsystem.mappers.PatientMapper;
import edu.miu.eprescribtionsystem.models.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
//    private final PatientMapper patientMapper;
    @GetMapping
    public Page<Patient> getAll(Pageable pageable){
        return  patientService.findAll(pageable);
//                .map(patientMapper::mapFromDTO);
    }


    @GetMapping("/{id}")
    public Patient getOne(Long id){
        return patientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient patient(Patient patient){
        return patientService.save(patient);
    }

    @PutMapping("/{id}")
    public Patient update(Long id, Patient patient){
        return patientService.update(id,patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){
        patientService.deleteById(id);
    }

}
