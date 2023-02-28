package com.knk.refrigerator_manager.recipe;

import com.knk.refrigerator_manager.ingre_recipe.Ingre_recipeRepository;
import com.knk.refrigerator_manager.ingre_refri.Ingre_refri;
import com.knk.refrigerator_manager.ingre_refri.Ingre_refriRepository;
import com.knk.refrigerator_manager.ingredient.Ingredient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final Ingre_recipeRepository ingre_recipeRepository;
    private final Ingre_refriRepository ingre_refriRepository;

    public Page<String> findPage(PageRequest pageRequest){
        return recipeRepository.findPageRecipeName(pageRequest);
    }

    public List<String> findAllRecipe(){
        log.info("findAllrecipe");
        return recipeRepository.findAllRecipeName();
    }

    public RecipeDTO getRecipeDTO(String name){
        //기본적으로 있는 메뉴에서 선정해서 디테일을 확인 null값이 있을수 없음
        Recipe recipe = recipeRepository.findByRecTitle(name).get();
        List<Ingredient> ingredients = ingre_recipeRepository.findIngredientByRecipeID(recipe.getRecID());

        //재료 map에 넣기
        Map<Long, String> ingreMap = new HashMap<>();
        for (Ingredient i: ingredients){
            ingreMap.put(i.getIngreID(), i.getIngreName());
        }

        RecipeDTO recipeDTO = new RecipeDTO().builder()
                .recID(recipe.getRecID())
                .rec_title(recipe.getRecTitle())
                .rec_category(recipe.getRec_category())
                .rec_description(recipe.getRec_description())
                .rec_link(recipe.getRec_link())
                .rec_view(recipe.getRec_view())
                .ingredients(ingreMap).build();

        return recipeDTO;
    }

    public List<String> getRecipeInRefri(Long refriID){
        int count = recipeRepository.findRecipeCount();
        log.info("count : "+count);

        //냉장고 번호 세션에서 받아오기
        List<Ingre_refri> ingre_refris = ingre_refriRepository.findAllByRefriID(refriID);
        List<Long> ingreIDs = new ArrayList<Long>();
        for(Ingre_refri i:ingre_refris){
            ingreIDs.add(i.getIngredient().getIngreID());
        }
        log.info("ingreIDs :" + ingreIDs.toString());
        //겹치는거 찾기
        List<String> recipes = new ArrayList<String>();
        //레시피 전부 돌기
        for(int i=1; i<=count; i++){
            Optional<Recipe> r = recipeRepository.findByRecID(Long.valueOf(i));
            if(r.isEmpty()) continue;
            List<Long> checkIngre = ingre_recipeRepository.findIngreIDByRecipeID(r.get().getRecID());
            log.info("checkIngre : " + checkIngre.toString());
            //레시피 재료가 전부 존재하는지 확인
            if(ingreIDs.containsAll(checkIngre)){
                recipes.add(r.get().getRecTitle());
            }
        }

        return recipes;
    }
}
