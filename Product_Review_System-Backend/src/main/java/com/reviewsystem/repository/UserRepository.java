package com.reviewsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.reviewsystem.model.User;
import java.util.Optional; 

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    Long countUsersByUsername(String username);
}
