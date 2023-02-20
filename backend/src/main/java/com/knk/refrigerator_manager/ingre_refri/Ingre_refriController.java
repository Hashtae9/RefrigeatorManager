package com.knk.refrigerator_manager.ingre_refri;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.knk.refrigerator_manager.ingredient.Ingredient;
import com.knk.refrigerator_manager.ingredient.IngredientDTO;
import com.knk.refrigerator_manager.ingredient.IngredientService;
import com.knk.refrigerator_manager.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ingre_refri")
@RequiredArgsConstructor
@Slf4j
public class Ingre_refriController {
    private final Ingre_refriService ingre_refriService;

    @GetMapping("/api/ingreInRefri")
    public ResponseEntity<List<IngreRefriResponseDTO>> getIngredientInRefri(){
        List<IngreRefriResponseDTO> ingre_refris = ingre_refriService.findAllIngredientInRefri();
        return ResponseEntity.status(HttpStatus.OK).body(ingre_refris);
    }

    //앱 내의 양식 입력으로 냉장고 내 재료 등록
    @PostMapping("/api/addIngre")
    public Long updateIngredient(@RequestBody ObjectNode saveObj){
        ObjectMapper mapper = new ObjectMapper();   // JSON을 Object화 하기 위한 Jackson ObjectMapper 이용
        IngredientDTO ingredientDTO = null;
        try {
            ingredientDTO = mapper.treeToValue(saveObj.get("ingreInfo"), IngredientDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        IngreRefriDTO ingreRefriDTO = null;
        try {
            ingreRefriDTO = mapper.treeToValue(saveObj.get("IngreRefriInfo"), IngreRefriDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ingre_refriService.saveIngredient(ingredientDTO, ingreRefriDTO);
    }

    // 바코드로 재료 등록

    // 재료 삭제
    @DeleteMapping("/api/deleteIngre")
    public Long deleteIngredient(@RequestBody IngredientDTO ingredientDTO){
        return ingre_refriService.delete(ingredientDTO);
    }

}
