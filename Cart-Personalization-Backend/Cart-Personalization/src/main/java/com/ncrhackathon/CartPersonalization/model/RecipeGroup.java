package com.ncrhackathon.CartPersonalization.model;

import java.util.List;
import java.util.Set;

public interface RecipeGroup {
	public void add(Recipe recipe);
	public List<Recipe> findTopMatches(Set<Ingredient> shoppingCart, int k);
}
