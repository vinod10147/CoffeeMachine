package beans;

import java.util.ArrayList;

public class Beverage {
    private String name;
    private ArrayList<Ingredient> ingredients;

    public Beverage(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredientSpecs(ArrayList<Ingredient> ingredientSpecs) {
        this.ingredients = ingredients;
    }
}
