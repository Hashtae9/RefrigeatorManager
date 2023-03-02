package com.knk.refrigerator_manager.ingre_refri;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.knk.refrigerator_manager.ingredient.IngredientDTO;
import com.knk.refrigerator_manager.refrigerator.RefriIDDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ingre_refri")
@RequiredArgsConstructor
@Slf4j
public class Ingre_refriController {
    private final Ingre_refriService ingre_refriService;

    @GetMapping("/api/ingreInRefri/{refriID}")
    public ResponseEntity<List<IngreRefriResponseDTO>> getIngredientInRefri(@PathVariable("refriID") Long refriID){
        List<IngreRefriResponseDTO> ingre_refris = ingre_refriService.findAllIngredientInRefri(refriID);
        return ResponseEntity.status(HttpStatus.OK).body(ingre_refris);
    }

    //앱 내의 양식 입력으로 냉장고 내 재료 등록
    @PostMapping("/api/addIngre")
    public ResponseEntity<Long> updateIngredient(@RequestBody ObjectNode saveObj){

        ObjectMapper mapper = new ObjectMapper();   // JSON을 Object화 하기 위한 Jackson ObjectMapper 이용
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RefriIDDTO refriIDDTO = null;
        try{
            refriIDDTO = mapper.treeToValue(saveObj.get("refriInfo"), RefriIDDTO.class);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

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

        return ResponseEntity.ok().body(ingre_refriService.saveIngredient(refriIDDTO, ingredientDTO, ingreRefriDTO));
    }

    // 재료 삭제
    @DeleteMapping("/api/deleteIngre")
    public ResponseEntity<Long> deleteIngredient(@RequestBody ObjectNode saveObj){
        ObjectMapper mapper = new ObjectMapper();

        RefriIDDTO refriIDDTO = null;
        try{
            refriIDDTO = mapper.treeToValue(saveObj.get("refriInfo"), RefriIDDTO.class);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        IngredientDTO ingredientDTO = null;
        try {
            ingredientDTO = mapper.treeToValue(saveObj.get("ingreInfo"), IngredientDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok().body(ingre_refriService.delete(refriIDDTO, ingredientDTO));
    }

}
