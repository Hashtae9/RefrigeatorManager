package com.knk.refrigerator_manager.ingre_recipe;

import com.knk.refrigerator_manager.ingre_refri.Ingre_refri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ingre_recipeService {
    private Ingre_recipeRepository ingre_recipeRepository;
    @Autowired
    public void setIngre_recipeRepository(Ingre_recipeRepository ingre_recipeRepository){
        this.ingre_recipeRepository = ingre_recipeRepository;
    }


}
