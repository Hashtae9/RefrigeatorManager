package com.knk.refrigerator_manager.ingredient;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    //첫 등록
    @Transactional
    public Long save(IngredientDTO ingredientDTO){
        //저장 후 생성한 id 반환
        return ingredientRepository.save(ingredientDTO.toEntity()).getIngre_seq();
    }

    //내용 수정
    @Transactional
    public String update(String ingreName, IngredientDTO ingredientDTO){
        Ingredient ingredient = ingredientRepository.findByIngreName(ingreName).orElseThrow(() -> new IllegalArgumentException("해당 재료는 없음."+ingreName));
        ingredient.update(ingredientDTO.getIngreName());
        return ingreName;
    }
}
