package com.knk.refrigerator_manager.ingre_refri;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date refriExpirDate;
    private Boolean frozen;

    //냉장고
    private Long refriID;
    private String refri_name;
}
