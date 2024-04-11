package edu.miu.eprescribtionsystem.repositories;

import edu.miu.eprescribtionsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
