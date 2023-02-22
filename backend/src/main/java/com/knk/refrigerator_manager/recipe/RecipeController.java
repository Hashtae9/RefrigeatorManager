package com.knk.refrigerator_manager.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.xml.stream.events.EntityReference;
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
    public ResponseEntity<Page<String>> getPageableRecipe(@PathVariable("pagenum") int page){
        PageRequest pageRequest = PageRequest.of(page, 5);
        return ResponseEntity.status(HttpStatus.OK).body(recipeService.findPage(pageRequest));
    }

    @GetMapping("/api/searchRecipe")
    public ResponseEntity<List<String>> getRecipe(){
        return ResponseEntity.status(HttpStatus.OK).body(recipeService.findAllRecipe());
    }

    @GetMapping("/api/detailRecipe/{recipeName}")
    public ResponseEntity<RecipeDTO> getDetailRecipe(@PathVariable("recipeName") String name){
        return ResponseEntity.status(HttpStatus.OK).body(recipeService.getRecipeDTO(name));
    }

    @GetMapping("/api/recommendRecipe")
    public ResponseEntity<List<String>> getRecommendRecipe(){
        List<String> recipes = recipeService.getRecipeInRefri();
        if(recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(recipes);
    }
}
