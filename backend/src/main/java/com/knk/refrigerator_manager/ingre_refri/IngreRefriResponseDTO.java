package com.knk.refrigerator_manager.ingre_refri;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class IngreRefriResponseDTO {
    //재료
    private Long ingreID;
    private String ingreName;
    private String imgSource;
    private Boolean defaultIngre;
    private Date refriExpirDate;
    private Boolean frozen;

    //냉장고
    private Long refriID;
    private String refri_name;
}
