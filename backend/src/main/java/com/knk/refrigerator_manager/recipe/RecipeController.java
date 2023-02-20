package com.knk.refrigerator_manager.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
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

    //레시피 받기
    @GetMapping("/api/searchRecipe/{pagenum}")
    public Page<String> getPageableRecipe(@PathVariable("pagenum") int page){
        PageRequest pageRequest = PageRequest.of(page, 5);
        return recipeService.findPage(pageRequest);
    }

    @GetMapping("/api/searchRecipe")
    public List<String> getRecipe(){
        return recipeService.findAllRecipe();
    }

//    @GetMapping("/api/detailRecipe/{recipeName}")
//    public
}
