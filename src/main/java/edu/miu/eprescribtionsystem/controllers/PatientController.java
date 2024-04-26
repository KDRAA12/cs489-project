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
    private final PatientMapper patientMapper;
    @GetMapping
    public Page<PatientDTO> getAll(Pageable pageable){
        return  patientService.findAll(pageable)
                .map(patientMapper::mapToDTO);
    }


    @GetMapping("/{id}")
    public PatientDTO getOne(Long id){
        return  patientMapper.mapToDTO(patientService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDTO patient(PatientDTO patient){
        return patientMapper.mapToDTO(patientService.save(
                patientMapper.mapFromDTO(patient)
        ));
    }

    @PutMapping("/{id}")
    public PatientDTO update(Long id, PatientDTO patient){
        return patientMapper.mapToDTO(patientService.update(id,
                patientMapper.mapFromDTO(patient)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){
        patientService.deleteById(id);
    }

}
