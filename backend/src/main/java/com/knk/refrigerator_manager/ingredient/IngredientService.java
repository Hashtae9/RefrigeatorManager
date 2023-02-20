package com.knk.refrigerator_manager.ingredient;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
        return ingredientRepository.save(ingredientDTO.toEntity()).getIngreID();
    }

    public Ingredient findIngreID(Long ID){
        Ingredient ingredient =  ingredientRepository.findById(ID).orElseThrow(() -> new IllegalArgumentException("해당 재료는 없음."));
        return ingredient;
    }

    public Ingredient findIngre(String ingreName){
        Ingredient ingredient =  ingredientRepository.findByIngreName(ingreName).orElseThrow(() -> new IllegalArgumentException("해당 재료는 없음."+ingreName));
        return ingredient;
    }

    //내용 수정
    @Transactional
    public String update(String ingreName, IngredientDTO ingredientDTO){
        Ingredient ingredient = ingredientRepository.findByIngreName(ingreName).orElseThrow(() -> new IllegalArgumentException("해당 재료는 없음."+ingreName));
        if(ingredient.getDefaultIngre() == Boolean.TRUE){
            log.info("해당 재료는 default가 아니기에 수정 불가");
            return "수정 불가";
        }
        else {
            ingredient.setIngreName(ingreName);
            return ingreName;
        }
    }
}
