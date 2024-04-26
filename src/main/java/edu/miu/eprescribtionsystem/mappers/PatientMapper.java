package edu.miu.eprescribtionsystem.mappers;


import edu.miu.eprescribtionsystem.dtos.PatientDTO;
import edu.miu.eprescribtionsystem.models.Patient;
import org.springframework.stereotype.Component;


@Component
public class PatientMapper {

    public Patient mapFromDTO(PatientDTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setGender(patientDTO.getGender());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        return patient;
    }

    public PatientDTO mapToDTO(Patient patient) {
        if (patient == null) {
            return null;
        }
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setGender(patient.getGender());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        return patientDTO;
    }
}

