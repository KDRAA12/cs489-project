package edu.miu.eprescribtionsystem.repositories;


import edu.miu.eprescribtionsystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
