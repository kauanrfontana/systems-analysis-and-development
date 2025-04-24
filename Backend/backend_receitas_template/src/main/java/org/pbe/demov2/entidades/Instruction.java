package org.pbe.demov2.entidades;

import lombok.Data;
import jakarta.persistence.*;

// entidade que representa instruções associadas a uma receita
@Entity
@Table(name = "instructions")
@Data
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Aqui se informa o relacionamento feito com a entidade Recipe
    // Se lá em Recipe foi definida uma relação 1:N com Instruction,
    // aqui se faz o contrário: N:1 (N instruções para 1 receita)
    // O atributo "recipe" aqui não representa uma coluna na tabela "instructions",
    // mas tão somente o relacionamento com a entidade Recipe
    // A anotação @JoinClumn indica qual coluna da tabela "instructions"
    // possui a referência da "recipe" ... a chave estrangeira.
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    // Getters, setters, equals, hashCode
}