package com.knk.refrigerator_manager.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select r.rec_title from Recipe as r")
    Page<String> findPageRecipeName(Pageable pageable);

    @Query("select r.rec_title from Recipe as r")
    List<String> findAllRecipeName();


}
