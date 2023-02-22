package com.knk.refrigerator_manager.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select r.recTitle from Recipe as r")
    Page<String> findPageRecipeName(Pageable pageable);

    @Query("select r.recTitle from Recipe as r")
    List<String> findAllRecipeName();

    @Query("select r from Recipe as r where r.recTitle = :recTitle")
    Optional<Recipe> findByRecTitle(@Param("recTitle") String recTitle);

    @Query("select Count(r.recID) from Recipe as r")
    int findRecipeCount();

    @Query("select r from Recipe as r where r.recID = :recID")
    Optional<Recipe> findByRecID(@Param("recID") Long id);

}
