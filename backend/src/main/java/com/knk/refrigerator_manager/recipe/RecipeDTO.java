package com.knk.refrigerator_manager.recipe;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class RecipeDTO {
    private Long recID;

}
