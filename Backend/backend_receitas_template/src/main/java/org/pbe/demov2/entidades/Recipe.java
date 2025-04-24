package org.pbe.demov2.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// Esta entidade representa uma receita
// Cada atributo corresponde a uma coluna da respectiva tabela
// Notem a correspondência entre a definição desta entidade e o objeto
// JSON retornado para o cliente
@Entity
@Table(name = "recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer prepTimeMinutes;
    private Integer cookTimeMinutes;
    private Integer servings;
    private String difficulty;
    private String cuisine;
    private Integer caloriesPerServing;
    private Integer userId;
    private String image;
    private Integer rating;
    private Integer reviewCount;

    // A seguir estão os relacionamentos entre Recipe e Ingredient, Instruction e Tag
    // Foram feitos relacionamentos 1:N ... uma receita está associada
    // a múltiplos ingredientes, instruções e tags
    // No Hibernate (que implementa a API JPA - Java Persistency API),
    // isso se faz com a anotação @OneToMany
    // Os argumentos dessa anotação são:
    // - mappedBy: nome do atributo da entidade Ingredient que referencia
    // esta entidade Recipe
    // cascade: indica que operações feitas nesta entidade devem ser propagadas
    // a entidades a ela relacionadas (ex: se apagar uma receita, apagam-se os
    // respectivos ingredientes)
    // orphanRemoval: indica que a entidade relacionada deve ser removida se for retirada
    // desta entidade que a contém
    @OneToMany(mappedBy="recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    // No caso de instructions, ordenam-se as entidades Instruction em
    // função de seus id. Talvez seja desnecessário, mas na dúvida ...
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    private List<Instruction> instructions = new ArrayList<>();

    @OneToMany(mappedBy="recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags = new ArrayList<>();

    // mealTypes é um bitmap para mapear os tipos de refeição
    // Isso é feito em ReceitaContent, que representa a receita
    // a ser retornada ao cliente em um objeto JSON
    private int mealTypes;

    // Getters, setters, equals, hashCode: usei @Data do lombok
}