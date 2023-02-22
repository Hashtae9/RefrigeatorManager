package com.knk.refrigerator_manager.ingredient;

import com.knk.refrigerator_manager.BacodeApi.BacodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public void setIngredientService(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    //바코드를 통한 재료 저장


    //앱 내에서 재료 저장
    @PostMapping("/api/save")
    public ResponseEntity<Long> save(@RequestBody IngredientDTO ingredientDTO){
        return ResponseEntity.ok().body(ingredientService.save(ingredientDTO));
    }

    //PathVariable은 파라미터 직접 바인딩
    //@RequestBody는 http의 body에서 IngredientDTO 직접 추출
    @PostMapping("/api/update")
    public ResponseEntity<String> update(@RequestBody IngredientDTO ingredientDTO) {
        return ResponseEntity.ok().body(ingredientService.update(ingredientDTO.getIngreName(), ingredientDTO));
    }

    @GetMapping("/api/bacode/{bacode}")
    public ResponseEntity<String> findByBacode(@PathVariable String bacode){
        String bacinfo = ingredientService.findByBacode(bacode);
        return ResponseEntity.ok().body(bacinfo);
    }
}
