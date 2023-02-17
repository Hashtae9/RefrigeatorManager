package com.knk.refrigerator_manager.ingredient;

import lombok.*;

@Getter
@NoArgsConstructor
public class IngredientDTO {
    private String ingreName;
    private String source;
    private String defaultCheck;

    @Builder
    public IngredientDTO(String ingre_name){
        this.ingreName = ingreName;
    }

    public Ingredient toEntity(){
        return Ingredient.builder().ingreName(ingreName).build();
    }
}
