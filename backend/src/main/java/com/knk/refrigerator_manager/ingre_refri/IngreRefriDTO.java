package com.knk.refrigerator_manager.ingre_refri;

import com.knk.refrigerator_manager.ingredient.Ingredient;
import com.knk.refrigerator_manager.refrigerator.Refrigerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class IngreRefriDTO {

    private Date refriExpirDate;
    private Boolean frozen;
    private Long ingreSeq;
    private Long refriID;

    @Builder
    public IngreRefriDTO(Long ingreSeq, Long refriID, Date refriExpirDate, Boolean frozen){
        this.refriExpirDate = refriExpirDate;
        this.frozen = frozen;
        this.ingreSeq = ingreSeq;
        this.refriID = refriID;
    }

    public Ingre_refri toEntity(Ingredient ingredient, Refrigerator refrigerator){
        return Ingre_refri.builder()
                .ingredient(ingredient)
                .refriExpirDate(refriExpirDate)
                .refrigerator(refrigerator)
                .frozen(frozen)
                .build();
    }
}
