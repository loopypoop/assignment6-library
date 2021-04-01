package edu.iitu.library.library.repository;

import edu.iitu.library.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getById(Integer id);
    User getByEmailAndPassword(String email, String password);
}
