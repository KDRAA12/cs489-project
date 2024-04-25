package edu.miu.eprescribtionsystem.repositories;
import edu.miu.eprescribtionsystem.models.MedicCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicCategoryRepository extends JpaRepository<MedicCategory,Long> {
}
