package com.knk.refrigerator_manager.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;
    @Autowired
    public void setRecipeService(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getPageableRecipe(){
        List<Recipe> recipes = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(recipes);
    }


}
