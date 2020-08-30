package main;

import beans.*;
import beans.json.InputJson;
import beans.json.Machine;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputProcessor {

    public static ArrayList<Beverage> jsonToBeverages(Machine machine) {
        ArrayList<Beverage> beverages = new ArrayList<Beverage>();
        for (Map.Entry<String, HashMap<String, Integer>> beverage : machine.getBeverages().entrySet()) {
            String name = beverage.getKey();
            HashMap<String, Integer> ingredientMap = beverage.getValue();
            ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
            for (Map.Entry<String, Integer> ingredient : ingredientMap.entrySet()) {
                ingredients.add(new Ingredient(ingredient.getKey(), ingredient.getValue()));
            }
            beverages.add(new Beverage(name, ingredients));
        }
        return beverages;
    }

    public static CoffeeMachine jsonToCoffeeMachine(Machine machine) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.setName("Aeropress");
        coffeeMachine.setSerialNo(10107);
        ArrayList<Outlet> outlets = new ArrayList();
        for (int outletId = 1; outletId <= machine.getOutlets().getCount_n(); outletId++) {
            outlets.add(new Outlet(outletId));
        }
        HashMap<String, IngredientContainer> containers = new HashMap<String, IngredientContainer>();
        for (Map.Entry<String, Integer> item : machine.getTotal_items_quantity().entrySet()) {
            IngredientContainer container = new IngredientContainer(item.getKey(), item.getValue(), false);
            containers.put(item.getKey(), container);
        }
        Specs specs = new Specs(outlets, containers);
        coffeeMachine.setSpecs(specs);
        return coffeeMachine;
    }

    public static InputJson readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file, "UTF-8");
        String input = "";
        while (scanner.hasNext()) {
            input += scanner.nextLine();
        }
        InputJson inputJson = new Gson().fromJson(input, InputJson.class);
        return inputJson;
    }
}
