package com.ncrhackathon.CartPersonalization.model;

import java.net.URL;

public class IngredientImpl implements Ingredient {
	long id;
	int price;
	String name;
	URL photo;

	public IngredientImpl(long id, int price, String name, URL photo) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.photo = photo;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public URL getPhoto() {
		return photo;
	}

	public String toString() {
		return this.getName();
	}
}

