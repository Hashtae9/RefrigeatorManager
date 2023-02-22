package com.knk.refrigerator_manager.recipe;

import lombok.*;

import java.util.Map;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class RecipeDTO {
    //레시피
    private Long recID;
    private String rec_title;
    private String rec_category;
    private String rec_description;
    private String rec_link;
    private int rec_view;

    //재료
    private Map<Long, String> ingredients;
}
