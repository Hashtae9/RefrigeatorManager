package com.knk.refrigerator_manager.ingredient;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name="ingredient")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Ingredient {
    @Id
    @Column(name = "ingre_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingre_seq;

    @Column(name = "ingre_name")
    private String ingre_name;

}
