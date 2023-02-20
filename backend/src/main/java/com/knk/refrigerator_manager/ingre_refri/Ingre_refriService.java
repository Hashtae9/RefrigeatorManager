package com.knk.refrigerator_manager.ingre_refri;

import com.knk.refrigerator_manager.ingredient.Ingredient;
import com.knk.refrigerator_manager.ingredient.IngredientDTO;
import com.knk.refrigerator_manager.ingredient.IngredientRepository;
import com.knk.refrigerator_manager.ingredient.IngredientService;
import com.knk.refrigerator_manager.refrigerator.Refrigerator;
import com.knk.refrigerator_manager.refrigerator.RefrigeratorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Ingre_refriService {
    private final Ingre_refriRepository ingre_refriRepository;
    private final IngredientRepository ingredientRepository;
    private final RefrigeratorRepository refrigeratorRepository;
    private final IngredientService ingredientService;

    //작업
    //내 냉장고에 기존에 존재하는 재료 넣기
    @Transactional
    public Long saveIngredient(IngredientDTO ingredientDTO, IngreRefriDTO ingreRefriDTO){
        Ingredient ingredient = null;
        Optional<Ingredient> ingredient1 = ingredientRepository.findByIngreName(ingredientDTO.getIngreName());
        //재료가 없다면 저장
        if(ingredient1.isEmpty()){
            ingredientRepository.save(ingredientDTO.toEntity());
        }
        //위에서 재료가 없다면 등록도 했기 때문에 무조건 존재
        ingredient = ingredientRepository.findByIngreName(ingredientDTO.getIngreName()).get();

         //냉장고는 무조건 존재
        Refrigerator refrigerator = refrigeratorRepository.findById(2L)
                .orElseThrow(() -> new IllegalArgumentException("해당 냉장고는 존재하지 않습니다. refrigerator ID = 1"));

        return ingre_refriRepository.save(ingreRefriDTO.toEntity(ingredient, refrigerator)).getIngreRefriId();
    }

    //재료확인하고 지우기
    @Transactional
    public Long delete(IngredientDTO ingredientDTO){
        Optional<Ingredient> ingredient1 = ingredientRepository.findByIngreName(ingredientDTO.getIngreName());
        Long ingreID = ingredient1.get().getIngreID();

        //현재는 그냥 입력받지만 session을 통해 refriID 받아오기
        Long refriID = 2L;
        Optional<Ingre_refri> byRefriIDAndIngreID = ingre_refriRepository.findByRefriIDAndIngreID(refriID, ingreID);
        Long id = null;
        if(byRefriIDAndIngreID.isPresent()){
            id = byRefriIDAndIngreID.get().getIngreRefriId();
            ingre_refriRepository.deleteById(id);
        }
        return id;
    }

    //냉장고속 재료 출력
    public List<IngreRefriResponseDTO> findAllIngredientInRefri(){
        List<Ingre_refri> ingre_refris = ingre_refriRepository.findAllByRefriID(2L);
        List<IngreRefriResponseDTO> ingreRefriResponseDTOS = new ArrayList<IngreRefriResponseDTO>();
        for(Ingre_refri i: ingre_refris){
            IngreRefriResponseDTO ingreRefriResponseDTO = new IngreRefriResponseDTO().builder()
                    .ingreID(i.getIngredient().getIngreID())
                    .ingreName(i.getIngredient().getIngreName())
                    .imgSource(i.getIngredient().getImgSource())
                    .defaultIngre(i.getIngredient().getDefaultIngre())
                    .refriExpirDate(i.getRefriExpirDate())
                    .frozen(i.getFrozen())
                    .refriID(i.getRefrigerator().getRefriID())
                    .refri_name(i.getRefrigerator().getRefri_name()).build();
            ingreRefriResponseDTOS.add(ingreRefriResponseDTO);
        }

        return ingreRefriResponseDTOS;
    }

}
