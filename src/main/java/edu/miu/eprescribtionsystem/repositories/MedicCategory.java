package edu.miu.eprescribtionsystem.repositories;

import edu.miu.eprescribtionsystem.models.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicCategory extends JpaRepository<Medic,Long> {
}
