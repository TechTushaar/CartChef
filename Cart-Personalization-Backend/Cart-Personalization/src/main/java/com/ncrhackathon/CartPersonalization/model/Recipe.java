package com.ncrhackathon.CartPersonalization.model;

import java.net.URL;
import java.util.Set;

public interface Recipe {
	public long getId();
	public String getName();
	public Set<Ingredient> getIngredients();
	public URL getPhoto();
	public URL getUrl();

	public Set<Ingredient> getRecipesByMissing(Set<Ingredient> ingredients);
}
