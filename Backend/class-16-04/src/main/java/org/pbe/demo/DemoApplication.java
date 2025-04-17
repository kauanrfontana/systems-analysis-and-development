package org.pbe.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping( value = "/recipes", produces = "application/json")
	public String getAllRecipes() throws IOException {
		Path filePath = Paths.get("src/main/resources/static/receitas/receita-0.json");
		byte[] fileBytes = Files.readAllBytes(filePath);
		return new String(fileBytes, StandardCharsets.UTF_8);
	}
	@GetMapping(value = "/recipes/{id}", produces = "application/json")
	public String getRecipesById() {
		return "Hello world !";
	}
	@PutMapping(value = "/receitas/{id}", produces = "application/json")
	public String updateRecipeById() {
		return "Hello world !";
	}

	@PostMapping(value = "/add", produces = "application/json")
	public String addRecipe() {
		return "Hello world !";
	}

}