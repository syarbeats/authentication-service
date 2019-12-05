package com.mts.cdc.authenticationservice.repository;

import com.mts.cdc.authenticationservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}
