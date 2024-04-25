package edu.miu.eprescribtionsystem.Services;

import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.Patient;
import edu.miu.eprescribtionsystem.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient findById(Long id){
        return patientRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Long id){
        Patient patient=findById(id);
        patientRepository.delete(patient);
    }

    public Patient update(Long id, Patient patient) {
        Patient patient1 = findById(id);
        patient.setId(id);
        return patientRepository.save(patient);
    }
    public Page<Patient> findAll(Pageable pageable){
        return patientRepository.findAll(pageable);
    }


    public Optional<Patient> findByPhoneNumber(String phoneNumber) {
        return patientRepository.findByPhoneNumber(phoneNumber);
    }
}
