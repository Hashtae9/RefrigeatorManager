package com.knk.refrigerator_manager.ingre_recipe;

import com.knk.refrigerator_manager.ingredient.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Ingre_recipeRepository extends JpaRepository<Ingre_recipe, Long> {
    @Query("select ir.ingredient from Ingre_recipe as ir where ir.recipe.recID = :recipeID")
    List<Ingredient> findIngredientByRecipeID(@Param("recipeID") Long id);

    @Query("select ir.ingredient.ingreID from Ingre_recipe as ir where ir.recipe.recID = :recipeID")
    List<Long> findIngreIDByRecipeID(@Param("recipeID") Long id);
}
