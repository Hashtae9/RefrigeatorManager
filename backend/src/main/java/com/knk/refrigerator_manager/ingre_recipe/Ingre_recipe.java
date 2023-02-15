package com.knk.refrigerator_manager.ingre_recipe;

import com.knk.refrigerator_manager.ingredient.Ingredient;
import com.knk.refrigerator_manager.recipe.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "ingre_recipe")
public class Ingre_recipe {
    @Id
    @Column(name = "ingre_recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingre_recipe_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rec_seq")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingre_seq")
    private Ingredient ingredient;

}
