package com.knk.refrigerator_manager.refrigerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RefriIDDTO {
    private Long refriID;

    @Builder
    public RefriIDDTO(Long refriID){
        this.refriID = refriID;
    }
}
