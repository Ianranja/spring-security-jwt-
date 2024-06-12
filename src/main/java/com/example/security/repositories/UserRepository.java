package com.example.security.repositories;


import com.example.security.entities.User;
import com.example.security.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    User findByRole(Role role);

//    User findFirstByEmail(String email);
}
