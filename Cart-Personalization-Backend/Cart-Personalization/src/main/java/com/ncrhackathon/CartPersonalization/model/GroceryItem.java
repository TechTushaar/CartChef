package com.ncrhackathon.CartPersonalization.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryItems")
public class GroceryItem {

    @Id
    private String id;

    private String name;
    private String brand;

    public GroceryItem(String id, String name, String brand) {
        super();
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
