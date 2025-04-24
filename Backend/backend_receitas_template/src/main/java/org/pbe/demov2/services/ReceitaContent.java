package org.pbe.demov2.services;

import lombok.Data;
import org.pbe.demov2.entidades.Ingredient;
import org.pbe.demov2.entidades.Instruction;
import org.pbe.demov2.entidades.Recipe;
import org.pbe.demov2.entidades.Tag;

import javax.naming.directory.NoSuchAttributeException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// representa uma receita a ser devolvida pro cliente
// ReceitaContent foi definida para que possa ser codificada
// em um objeto JSON no formato esperado pelo cliente
@Data
public class ReceitaContent {
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
    private List<String> ingredients;
    private List<String> instructions;
    private List<String> tags;
    private List<String> mealTypes;

    public enum EMealTypes {
        Dinner(1, "dinner"), Lunch(2, "lunch"), Breakfast(4, "breakfast");

        public int mealType;
        public String mealDesc;

        EMealTypes(int tipo, String desc) {
            mealType = tipo;
            mealDesc = desc;
        }

        static EMealTypes fromName(String name) throws NoSuchAttributeException{
            for (var tipo: EMealTypes.values()) {
                if (name.equals(tipo.mealDesc)) {
                    return tipo;
                }
            }
            throw new NoSuchAttributeException(name);
        }
    };

    ReceitaContent(Recipe r) {
        id = r.getId();
        name = r.getName();
        prepTimeMinutes = r.getPrepTimeMinutes();
        cookTimeMinutes = r.getCookTimeMinutes();
        servings = r.getServings();
        difficulty = r.getDifficulty();
        cuisine = r.getCuisine();
        caloriesPerServing = r.getCaloriesPerServing();
        userId = r.getUserId();
        image = r.getImage();
        rating = r.getRating();
        reviewCount = r.getReviewCount();
        ingredients = r.getIngredients().stream().map((x) -> x.getName()).collect(Collectors.toList());
        instructions = r.getInstructions().stream().map((x) -> x.getDescription()).collect(Collectors.toList());
        tags = r.getTags().stream().map((x) -> x.getName()).collect(Collectors.toList());
        mealTypes = decodeMealTypes(r.getMealTypes());
    }

    List<String> decodeMealTypes(int tipos) {
        ArrayList<String> result = new ArrayList<>();

        for (var tipo: EMealTypes.values()) {
            if ((tipos & tipo.mealType) != 0) {
                result.add(tipo.mealDesc);
            }
        }

        return result;
    }

    int encodeMealTypes(List<String> tipos) {
        int mealType = 0;

        for (var nome: tipos) {
            try {
                mealType |= EMealTypes.fromName(nome).mealType;
            } catch (NoSuchAttributeException e) {
                // pass
            }
        }

        return mealType;
    }


    Recipe toRecipe() {
        Recipe r = new Recipe();

        r.setId(id);
        r.setCaloriesPerServing(caloriesPerServing);
        r.setCookTimeMinutes(cookTimeMinutes);
        r.setCuisine(cuisine);
        r.setDifficulty(difficulty);
        r.setImage(image);
        r.setName(name);
        r.setPrepTimeMinutes(prepTimeMinutes);
        r.setRating(rating);
        r.setReviewCount(reviewCount);
        r.setServings(servings);
        r.setUserId(userId);
        r.setMealTypes(encodeMealTypes(mealTypes));

        List<Ingredient> l_ingredients = new ArrayList<>();
        for (var ingredient_name: ingredients) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredient_name);
            ingredient.setRecipe(r);
            l_ingredients.add(ingredient);
        }
        r.setIngredients(l_ingredients);

        List<Instruction> l_instructions = new ArrayList<>();
        for (var instruction_desc: instructions) {
            Instruction instruction = new Instruction();
            instruction.setDescription(instruction_desc);
            instruction.setRecipe(r);
            l_instructions.add(instruction);
        }
        r.setInstructions(l_instructions);

        List<Tag> l_tags = new ArrayList<>();
        for (var tag_name: tags) {
            Tag tag = new Tag();
            tag.setName(tag_name);
            tag.setRecipe(r);
            l_tags.add(tag);
        }
        r.setTags(l_tags);

        return r;
    }
}