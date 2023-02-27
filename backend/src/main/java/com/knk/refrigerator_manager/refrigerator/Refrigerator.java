package com.knk.refrigerator_manager.refrigerator;

import com.knk.refrigerator_manager.ingre_refri.Ingre_refri;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "refrigerator")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Refrigerator {
    @Id
    @Column(name = "refri_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refriID;

    @Column(name = "refri_name")
    private String refri_name;

    @Column(name = "refri_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate refri_date;

//    @OneToOne(mappedBy = "refrigerator")
//    private User user;

    //냉장고 입장에서는 어떤 재료가 있는지 알아야함
    @OneToMany(mappedBy = "refrigerator", cascade = CascadeType.PERSIST)
    private List<Ingre_refri> ingre_refris = new ArrayList<>();
}
