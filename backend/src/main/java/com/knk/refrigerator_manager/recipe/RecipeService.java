package com.knk.refrigerator_manager.recipe;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public Page<String> findPage(PageRequest pageRequest){
        return recipeRepository.findPageRecipeName(pageRequest);
    }

    public List<String> findAllRecipe(){
        return recipeRepository.findAllRecipeName();
    }
}
