package com.knk.refrigerator_manager.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    public Optional<Ingredient> findByIngreName(String ingreName);
}
