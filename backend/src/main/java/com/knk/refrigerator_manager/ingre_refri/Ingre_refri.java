package com.knk.refrigerator_manager.ingre_refri;

import com.knk.refrigerator_manager.ingredient.Ingredient;
import com.knk.refrigerator_manager.refrigerator.Refrigerator;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "ingre_refri")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Ingre_refri {
    @Id
    @Column(name = "ingre_refri_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingre_refri_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "refri_seq")
    private Refrigerator refri_seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ingre_seq")
    private Ingredient ingre_seq;

    @Column(name = "refri_expir_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date refri_expir_date;

    @Column(name = "frozen")
    private Boolean frozen;

}
