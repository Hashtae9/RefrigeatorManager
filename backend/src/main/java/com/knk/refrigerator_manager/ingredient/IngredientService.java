package com.knk.refrigerator_manager.ingredient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knk.refrigerator_manager.BacodeApi.BacodeApi;
import com.knk.refrigerator_manager.BacodeApi.BacodeDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final BacodeApi bacodeApi;

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

    @Transactional
    public String findByBacode(String b){
        String bacode = ((bacodeApi.requestBacode(b).split("PRDLST_NM\":\"" ))[1].split("\","))[0].strip();
        log.info(bacode.strip());
        String[] checkS = bacode.split("\\s+");

        for(String i: checkS){
            log.info(i);
            Optional<Ingredient> ingredient = ingredientRepository.findByIngreName(i);
            if(ingredient.isPresent()) return ingredient.get().getIngreName();
        }

        if(ingredientRepository.findByIngreName(bacode).isPresent()){
            return bacode;
        }
        //바코드명이 없을 경우
        IngredientDTO ingredientDTO = IngredientDTO.builder()
                .ingreName(bacode)
                .defaultIngre(Boolean.TRUE) //만든거
                .build();
        ingredientRepository.save(ingredientDTO.toEntity());
        return bacode;
    }
}
