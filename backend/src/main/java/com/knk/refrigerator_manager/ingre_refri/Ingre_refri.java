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
    private Long ingreRefriId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refri_seq", nullable = false)
    private Refrigerator refrigerator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingre_seq", nullable = false)
    private Ingredient ingredient;

    @Column(name = "refri_expir_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date refriExpirDate;

    @Column(name = "frozen")
    private Boolean frozen;

}
