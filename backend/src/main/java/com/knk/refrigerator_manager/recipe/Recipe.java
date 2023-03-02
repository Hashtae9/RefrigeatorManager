package com.knk.refrigerator_manager.recipe;

import com.knk.refrigerator_manager.ingre_recipe.Ingre_recipe;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "recipe")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_seq")
    private Long recID;

    @Column(name = "rec_title")
    private String recTitle;

    @Column(name = "rec_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date rec_date;

    @Column(name = "rec_description", length = 1000)
    private String rec_description;

    @Column(name = "rec_link")
    private String rec_link;

    @Column(name = "rec_view")
    private int rec_view;

    @Column(name = "rec_category")
    private String rec_category;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Ingre_recipe> ingre_recipes = new ArrayList<>();
}
