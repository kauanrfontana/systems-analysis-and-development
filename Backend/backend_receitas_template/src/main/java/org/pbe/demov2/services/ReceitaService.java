package org.pbe.demov2.services;

import lombok.Data;
import org.pbe.demov2.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    // usado para testar se consegue adicionar algo ao banco de dados
    public ReceitaContent testa_bd() {
        Recipe r = new Recipe();
        r.setCuisine("bras");
        r.setImage("nada");
        r.setDifficulty("medium");
        r.setName("teste");
        r.setRating(5);
        r.setCookTimeMinutes(10);
        r.setCaloriesPerServing(100);
        r.setMealTypes(1);
        r.setPrepTimeMinutes(5);
        r.setReviewCount(10);
        r.setServings(2);
        r.setUserId(111);

        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("farinha");
        ingredient.setRecipe(r);
        ingredients.add(ingredient);
        ingredient = new Ingredient();
        ingredient.setName("agura");
        ingredient.setRecipe(r);
        ingredients.add(ingredient);

        r.setIngredients(ingredients);

        List<Instruction> instructions = new ArrayList<>();
        Instruction instruction = new Instruction();
        instruction.setDescription("liga forno");
        instruction.setRecipe(r);
        instructions.add(instruction);
        instruction = new Instruction();
        instruction.setDescription("assa pizza");
        instruction.setRecipe(r);
        instructions.add(instruction);
        r.setInstructions(instructions);

        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setName("boa");
        tag.setRecipe(r);
        tags.add(tag);
        tag = new Tag();
        tag.setName("brasileira");
        tags.add(tag);
        tag.setRecipe(r);
        r.setTags(tags);

        return new ReceitaContent(receitaRepository.save(r));
    }

    // gera uma lista das receitas contidas neste serviço
    public List<ReceitaContent> obtem_receitas() throws Exception{
        List<Recipe> recipes = receitaRepository.findAll();
        List<ReceitaContent> recipesContent = new ArrayList<>();
        for(Recipe recipe : recipes){
            recipesContent.add(new ReceitaContent(recipe));
        }
        return recipesContent;
    }

    // obtém a receita identificada por id
    public ReceitaContent obtem_receita(int id) {
        Optional<Recipe> recipe = receitaRepository.findById((long)id);
        return recipe.map(ReceitaContent::new).orElse(null);
    }

    // substitui o conteúdo da receita identificada por id
    // retorna conteúdo da nova receita
    public ReceitaContent substitui_receita(int id, String receita) {
        return null;
    }

    // adiciona uma nova receita, e retorna seu id
    public ReceitaContent adiciona_receita(String receita) {
        return null;
    }

}