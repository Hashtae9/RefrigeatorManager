package com.knk.refrigerator_manager.refrigerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class RefrigeratorDTO {
    private String refri_name;

    @Builder
    public RefrigeratorDTO(String refri_name){
        this.refri_name = refri_name;
    }

    public Refrigerator toEntity(){
        return Refrigerator.builder().refri_name(refri_name).build();
    }
}
