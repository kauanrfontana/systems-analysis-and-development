package org.pbe.demov2.entidades;

import jakarta.persistence.*;
import lombok.Data;

// entidade que representa tags associadas a uma receita
@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Se lá em Recipe foi definida uma relação 1:N com Tag,
    // aqui se faz o contrário: N:1 (N tags para 1 receita)
    // O atributo "recipe" aqui não representa uma coluna na tabela "tags",
    // mas tão somente o relacionamento com a entidade Recipe
    // A anotação @JoinClumn indica qual coluna da tabela "tags"
    // possui a referência da "recipe" ... a chave estrangeira.
    @ManyToOne
    @JoinColumn(name="recipe_id", nullable = false)
    private Recipe recipe;

    // Getters, setters, equals, hashCode
}