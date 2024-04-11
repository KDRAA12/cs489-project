package edu.miu.eprescribtionsystem.repositories;


import edu.miu.eprescribtionsystem.models.BasicPrescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicPrescriptionRepository extends JpaRepository<BasicPrescription,Long> {
}
