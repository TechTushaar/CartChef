package com.ncrhackathon.CartPersonalization.controller;

import com.ncrhackathon.CartPersonalization.model.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ncrhackathon.CartPersonalization.client.TastyClient;
import com.ncrhackathon.CartPersonalization.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

	@CrossOrigin(origins = "*")
    @PutMapping( value = "/v1/getItems", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRecipe(@RequestBody CartRequestDTO shoppingCart)
    {
        List<FullMealDTO> matchingMealList = recipeService.findTopMatchingMeal(shoppingCart.getShoppingCart());
		List<FinalRecipeDTO> response = new ArrayList<FinalRecipeDTO>();

		for (var matchingMeal : matchingMealList) {
			Set<String> recipeIngredientsSet = recipeService.createIngredientsSetForMatchingMeal(matchingMeal);
			Set<String> customerCart = new HashSet<>(shoppingCart.getShoppingCart());
			Set<String> missingIngredients = recipeService.findMissingIngredientsInCart(recipeIngredientsSet, customerCart);
			FinalRecipeDTO recipeRecommendation = recipeService.generateJsonRecipeResponse(matchingMeal, missingIngredients);
			response.add(recipeRecommendation);
		}
		
        return ResponseEntity.ok(response);
    }
}
