package com.knk.refrigerator_manager.refrigerator;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefrigeratorRepository extends JpaRepository<Refrigerator, Long> {
    @Override
    Optional<Refrigerator> findById(Long refriID);
}
