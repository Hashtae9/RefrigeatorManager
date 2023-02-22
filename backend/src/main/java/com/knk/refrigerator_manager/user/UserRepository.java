package com.knk.refrigerator_manager.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    Optional<User> findByEmailAndPhone(String email, String phone);
    Optional<User> findByUsernameAndEmail(String username, String email);
    Boolean existsByUsername(String username);
}
