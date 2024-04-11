package edu.miu.eprescribtionsystem.repositories;

import edu.miu.eprescribtionsystem.models.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic,Long> {
}
