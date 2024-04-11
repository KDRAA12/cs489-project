package edu.miu.eprescribtionsystem.repositories;


import edu.miu.eprescribtionsystem.models.TemplatePrescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplatePrescriptionRepository extends JpaRepository<TemplatePrescription,Long> {
}
