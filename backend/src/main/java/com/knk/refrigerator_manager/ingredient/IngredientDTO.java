package com.knk.refrigerator_manager.ingredient;

import jakarta.persistence.Column;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class IngredientDTO {
    private String ingreName;
    private String imgSource;
    private Boolean defaultIngre;


    @Builder
    public IngredientDTO(String ingreName, String imgSource, Boolean defaultIngre){
        this.ingreName = ingreName;
        this.imgSource = imgSource;
        this.defaultIngre = defaultIngre;
    }

    public Ingredient toEntity(){
        return Ingredient.builder()
                .ingreName(ingreName)
                .imgSource(imgSource)
                .defaultIngre(defaultIngre)
                .build();
    }
}
