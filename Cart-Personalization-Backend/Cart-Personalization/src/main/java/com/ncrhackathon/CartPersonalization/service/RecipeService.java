package com.ncrhackathon.CartPersonalization.service;

import com.ncrhackathon.CartPersonalization.client.TastyClient;
import com.ncrhackathon.CartPersonalization.model.FinalRecipeDTO;
import com.ncrhackathon.CartPersonalization.model.FullMealDTO;
import com.ncrhackathon.CartPersonalization.model.MealsIdDTO;
import com.ncrhackathon.CartPersonalization.model.MiniMealDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.http.HttpTimeoutException;
import java.util.*;

@Service
public class RecipeService {

    @Autowired
    private TastyClient tastyClient;

	// Max number of ingredients ran at a time against api
	private final int MAX_INGREDIENTS_CHECK = 3;
	
	// Max number of returned recipe recommendations
	private final int MAX_RECOMMENDATIONS = 3;

	// Jump over this many ingredients after each check
	// this is to avoid checking ingredients that only differ by 1
	private final int JUMP_INGREDIENTS_AMOUNT = 2;

	/**
	 * String preprocessing of ingredients
	 */
	private String ingredientsToString(List<String> ingredients) {
        StringBuilder ingredientsString = new StringBuilder();
        for (String s: ingredients) {
            ingredientsString.append(s.toLowerCase());
            ingredientsString.append(",");
        }

        ingredientsString.deleteCharAt(ingredientsString.length() - 1);
		return ingredientsString.toString();
	}

	/**
	 *  Group given ingredients to check against api
	 */
	private List<String> processIngredients(List<String> ingredients) {
		List<String> groups = new ArrayList<String>();

		int ingredientsGroupLength = Math.max(JUMP_INGREDIENTS_AMOUNT, ingredients.size() - MAX_INGREDIENTS_CHECK + 1);
		for (int i = 0; i < ingredientsGroupLength; i += JUMP_INGREDIENTS_AMOUNT) {
			List<String> ingredientsList = new ArrayList<String>();

			for (int j = i; j < Math.min(i + MAX_INGREDIENTS_CHECK, ingredients.size()); j++) {
				ingredientsList.add(ingredients.get(j));
			}

			groups.add(ingredientsToString(ingredientsList));
		}

		return groups;
	}

	private List<FullMealDTO> getMealMatches(String ingredientsString, List<FullMealDTO> mealDetails) {
		//Pass to client for matching meals
		List<MiniMealDTO> matchingMeal = tastyClient.findRecipeId(ingredientsString).getMeals();

		if (matchingMeal == null || matchingMeal.isEmpty()) {
			return mealDetails;
		}

		// Add all matching meals for given ingredients
		for (int i = 0; i < matchingMeal.size(); i++) {
			//Get full details of the selected meal
			var matchingMealId = matchingMeal.get(i).getIdMeal();
			FullMealDTO selectedMealDetails = tastyClient.getRecipeDetailsById(matchingMealId).getMeals().get(0);

			System.out.println("*********************");
			System.out.println(matchingMealId);
			System.out.println("*********************");

			if (!mealDetails.contains(selectedMealDetails)) {
				System.out.println("ADDED");
				mealDetails.add(selectedMealDetails);
			}

			// Don't add more than the maximum allowed recommendations
			if (MAX_RECOMMENDATIONS <= mealDetails.size()) {
				break;
			}
		}

		return mealDetails;
	}

	// this should be replaced by a set for efficiency if time allows
	private List<FullMealDTO> mergeMeals(List<FullMealDTO> meal1, List<FullMealDTO> meal2) {
		for (var meal : meal2) {
			if (!meal1.contains(meal)) {
				meal1.add(meal);
			}
		}

		return meal1;
	}

	/**
	 *  Return the top matching meals for the given ingredients
	 */
    public List<FullMealDTO> findTopMatchingMeal(List<String> ingredients) {
		var ingredientGroups = processIngredients(ingredients);

		List<FullMealDTO> mealDetails = new ArrayList<FullMealDTO>();

		// Check matches against ingredients
		for (String ingredientsString : ingredientGroups) {
			// TODO: if time permits, use a set for efficiency
			var currentMatches = getMealMatches(ingredientsString, mealDetails);
			mealDetails = mergeMeals(mealDetails, currentMatches);

			// Don't add more than the maximum allowed recommendations
			if (MAX_RECOMMENDATIONS <= mealDetails.size()) {
				break;
			}
		}

		// hacky but it works; improve in future
		if (mealDetails.size() == 0 && ingredients.size() > 0) {
			var currentMatches = getMealMatches(ingredients.get(0), mealDetails);
			mealDetails = mergeMeals(mealDetails, currentMatches);
		}

        return mealDetails;
    }

    public Set<String> createIngredientsSetForMatchingMeal(FullMealDTO meal) {

        Set<String> set = new HashSet<>();

        for (int i = 1; i < 21; i++) {
            try {
                Method method = meal.getClass().getDeclaredMethod("getStrIngredient" + i);
                String s = (String) method.invoke(meal);
                if (s != null) {
                    set.add(s.toLowerCase());
                }
            } catch (Exception e) {
                System.out.println("Bad things happen");
            }
        }
        return set;
    }

    public Set<String> findMissingIngredientsInCart(Set<String> recipeIngredientSet, Set<String> customerCart) {
        recipeIngredientSet.removeAll(customerCart); // a set of missing ingredients
        return recipeIngredientSet;
        //still need to cross - confirm with inventory list
    }

    public FinalRecipeDTO generateJsonRecipeResponse(FullMealDTO meal, Set<String> missingIngredients) {
        List<String> missingList = new ArrayList<>(missingIngredients);
        FinalRecipeDTO response = new FinalRecipeDTO(
                meal.getStrMeal(),
                meal.getStrMealThumb(),
                missingList,
                meal.getStrInstructions()
        );
        return response; // singular item for now

    }
}
