package service;

import beans.Beverage;
import beans.CoffeeMachine;
import beans.Ingredient;
import beans.IngredientContainer;

import java.util.ArrayList;
import java.util.HashMap;

public class BeverageService {


    CoffeeMachine coffeeMachine;

    public BeverageService(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public String serveBeverage(Beverage beverage) {
        String status = getStatus(beverage);
        if (status.equalsIgnoreCase("true")) {
            return beverage.getName() + " is prepared";
        }
        return beverage.getName() + " cannot be prepared because " + status;
    }

    private String getStatus(Beverage beverage) {
        HashMap<String, IngredientContainer> containers = coffeeMachine.getSpecs().getContainers();
        for (Ingredient ingredient : beverage.getIngredients()) {
            if (!containers.containsKey(ingredient.getName()))
                return ingredient.getName() + " is not available";
            if (containers.get(ingredient.getName()).getCurVolume() < ingredient.getVolume()) {
                return ingredient.getName() + " is not sufficient";
            }
        }
        extractBeverage(beverage);
        return "true";
    }

    private void extractBeverage(Beverage beverage) {
        HashMap<String, IngredientContainer> containers = coffeeMachine.getSpecs().getContainers();
        for (Ingredient ingredient : beverage.getIngredients()) {
            Integer newVolume = containers.get(ingredient.getName()).getCurVolume() - ingredient.getVolume();
            containers.get(ingredient.getName()).setCurVolume(newVolume);
        }
    }

    public void serveBeverages(ArrayList<Beverage> beverages) {
        for (Beverage beverage : beverages) {
            System.out.println(serveBeverage(beverage));
        }
    }
}
