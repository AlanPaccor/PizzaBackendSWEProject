package com.pizzashop.pizzabackend.menu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuDataLoader {

    @Bean
    CommandLineRunner loadMenu(MenuItemRepository repository) {
        return args -> {

            if (repository.count() > 0) {
                return;
            }

            // sizes
            repository.save(new MenuItem(
                    "SIZE", "small", "Small (10\")",
                    "Personal 6-slice pie", 10.99));

            repository.save(new MenuItem(
                    "SIZE", "medium", "Medium (12\")",
                    "Great for 2 people (8 slices)", 13.99));

            repository.save(new MenuItem(
                    "SIZE", "large", "Large (14\")",
                    "Family favorite (8 large slices)", 16.99));

            repository.save(new MenuItem(
                    "SIZE", "xlarge", "X-Large (16\")",
                    "Party size (12 slices)", 19.99));

            // crusts
            repository.save(new MenuItem(
                    "CRUST", "hand-tossed", "Classic Hand-Tossed",
                    "Traditional", 0.00));

            repository.save(new MenuItem(
                    "CRUST", "thin-crispy", "Thin & Crispy",
                    "Extra Crunch", 0.00));

            repository.save(new MenuItem(
                    "CRUST", "stone-thick", "Stone-Baked Thick",
                    "Chewy & Airy", 0.00));

            repository.save(new MenuItem(
                    "CRUST", "garlic-parm", "Garlic Butter Herb",
                    "House Special", 0.00));

            // sauces
            repository.save(new MenuItem(
                    "SAUCE", "light", "Light Sauce",
                    "Light amount of sauce", 0.00));

            repository.save(new MenuItem(
                    "SAUCE", "normal", "Normal Sauce",
                    "Regular amount of sauce", 0.00));

            repository.save(new MenuItem(
                    "SAUCE", "extra", "Extra Sauce",
                    "Extra amount of sauce", 0.00));

            // vegetables
            repository.save(new MenuItem(
                    "VEGGIE", "mushrooms", "Fresh Mushrooms",
                    "", 1.25));

            repository.save(new MenuItem(
                    "VEGGIE", "red-onions", "Caramelized Red Onion",
                    "", 1.00));

            repository.save(new MenuItem(
                    "VEGGIE", "bell-peppers", "Green Bell Peppers",
                    "", 1.00));

            repository.save(new MenuItem(
                    "VEGGIE", "black-olives", "Kalamata Black Olives",
                    "", 1.25));

            repository.save(new MenuItem(
                    "VEGGIE", "spinach", "Baby Spinach",
                    "", 1.25));

            repository.save(new MenuItem(
                    "VEGGIE", "roma-tomatoes", "Sliced Roma Tomatoes",
                    "", 1.25));

            // meats
            repository.save(new MenuItem(
                    "MEAT", "pepperoni", "Artisan Pepperoni",
                    "", 1.75));

            repository.save(new MenuItem(
                    "MEAT", "italian-sausage", "Spicy Italian Sausage",
                    "", 1.75));

            repository.save(new MenuItem(
                    "MEAT", "bacon", "Smoked Crispy Bacon",
                    "", 2.00));

            repository.save(new MenuItem(
                    "MEAT", "grilled-chicken", "Herbed Grilled Chicken",
                    "", 2.00));

            repository.save(new MenuItem(
                    "MEAT", "prosciutto", "Dry-Cured Prosciutto",
                    "", 2.50));

            repository.save(new MenuItem(
                    "MEAT", "meatballs", "Handcrafted Beef Meatballs",
                    "", 2.00));
        };
    }
}