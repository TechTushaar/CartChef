package com.ncrhackathon.CartPersonalization.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RecipeGroupImpl implements RecipeGroup {
	List<Recipe> recipes;

	public RecipeGroupImpl() {
		this.recipes = new ArrayList();
	}

	public RecipeGroupImpl(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public void add(Recipe recipe) {
		recipes.add(recipe);
	}

	public List<Recipe> findTopMatches(Set<Ingredient> shoppingCart, int k) {
		// TODO: Currently ignoring `k`. Get only top k items
		// TODO: Can improve efficiency (if time permits)
		//       Could try using a sliding window
		Map<Recipe, Integer> recipeSorter = new HashMap<Recipe, Integer>();

		for (var recipe : recipes) {
			var numOfMissing = new Integer(recipe.getRecipesByMissing(shoppingCart).size());
			recipeSorter.put(recipe, numOfMissing);
		}

		return recipeSorter.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
	}
}
