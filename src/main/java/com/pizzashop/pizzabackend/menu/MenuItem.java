package com.pizzashop.pizzabackend.menu;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String itemId;
    private String name;
    private String description;
    private double price;

    public MenuItem(){
    }

    public MenuItem(String category, String itemId, String name, String description, double price) {
        this.category = category;
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }
    public String getItemId() {
        return itemId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
