package com.knk.refrigerator_manager.refrigerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Setter @Getter
@NoArgsConstructor
public class RefrigeratorDTO {
    private String refri_name;
    private LocalDate refri_date;

    // 현재 날짜 구하기
    LocalDate now = LocalDate.now();

    @Builder
    public RefrigeratorDTO(String refri_name){
        this.refri_name = refri_name;
    }

    public Refrigerator toEntity(){
        return Refrigerator.builder()
                .refri_name(refri_name)
                .refri_date(now)
                .build();
    }
}
