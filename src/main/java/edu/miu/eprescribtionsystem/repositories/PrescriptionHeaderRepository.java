package edu.miu.eprescribtionsystem.repositories;


import edu.miu.eprescribtionsystem.models.PrescriptionHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionHeaderRepository extends JpaRepository<PrescriptionHeader,Long> {

}
