package com.ncrhackathon.CartPersonalization.model;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class RecipeImpl implements Recipe {
	private long id;
	private String name;
	private Set<Ingredient> ingredients;

	private URL photo;
	private URL url;

	public RecipeImpl(long id, String name, Set<Ingredient> ingredients, URL photo, URL url) {
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.photo = photo;
		this.url = url;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	@Override
	public URL getPhoto() {
		return photo;
	}

	@Override
	public URL getUrl() {
		return url;
	}

	@Override
	/**
	   Returns the recipes in order of missing ingredients
	 */
	public Set<Ingredient> getRecipesByMissing(Set<Ingredient> ingredients) {
		if (ingredients == null) {
			throw new NullPointerException();
		}

		Set<Ingredient> missingIngredients = new HashSet<Ingredient>();
		missingIngredients.addAll(this.ingredients);
		missingIngredients.removeAll(ingredients);
		return missingIngredients;
	}
}
