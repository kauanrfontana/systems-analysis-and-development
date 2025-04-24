package org.pbe.demov2.entidades;

import lombok.Data;
import jakarta.persistence.*;

// entidade que representa ingredientes associados a uma receita
@Entity
@Table(name = "ingredients")
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Se lá em Recipe foi definida uma relação 1:N com Ingredient,
    // aqui se faz o contrário: N:1 (N ingredientes para 1 receita)
    // O atributo "recipe" aqui não representa uma coluna na tabela "ingredients",
    // mas tão somente o relacionamento com a entidade Recipe
    // A anotação @JoinClumn indica qual coluna da tabela "ingredients"
    // possui a referência da "recipe" ... a chave estrangeira.
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    // Getters, setters, equals, hashCode
}