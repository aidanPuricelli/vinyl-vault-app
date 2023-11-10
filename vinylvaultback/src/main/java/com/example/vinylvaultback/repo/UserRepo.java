package com.example.vinylvaultback.repo;
import com.example.vinylvaultback.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository< User, Long > {

    User findUserById(Long id);
    User findUserByEmail(String email);

    Optional<User> findOneByEmailAndPassword(String email, String password);

}
