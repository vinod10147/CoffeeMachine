import beans.Beverage;
import beans.CoffeeMachine;
import beans.Ingredient;
import beans.json.InputJson;
import main.InputProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.BeverageService;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalTests {

    CoffeeMachine coffeeMachine;

    @BeforeEach
    public void run() throws FileNotFoundException {
        InputJson inputJson = InputProcessor.readFile("input.json");
        coffeeMachine = InputProcessor.jsonToCoffeeMachine(inputJson.getMachine());
    }

    @Test
    public void serveBeveragePrepared() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 50));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("sugar_syrup", 30));
        BeverageService service = new BeverageService(coffeeMachine);
        String output = service.serveBeverage(new Beverage("hot_tea", ingredients));
        assertEquals("hot_tea is prepared", output);

    }

    @Test
    public void serveBeverageNotSufficient() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 500));
        ingredients.add(new Ingredient("ginger_syrup", 400));
        ingredients.add(new Ingredient("sugar_syrup", 300));
        BeverageService service = new BeverageService(coffeeMachine);
        String output = service.serveBeverage(new Beverage("hot_tea", ingredients));
        assertEquals("hot_tea cannot be prepared because ginger_syrup is not sufficient", output);
    }

    @Test
    public void serveBeverageNotAvailable() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 500));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("green_mixture", 300));
        BeverageService service = new BeverageService(coffeeMachine);
        String output = service.serveBeverage(new Beverage("hot_tea", ingredients));
        assertEquals("hot_tea cannot be prepared because green_mixture is not available", output);

    }

    @Test
    public void serveBeveragesPrepared() {
        BeverageService service = new BeverageService(coffeeMachine);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 50));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("sugar_syrup", 30));
        String output = service.serveBeverage(new Beverage("hot_tea", ingredients));
        assertEquals("hot_tea is prepared", output);
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 200));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("tea_leaves_syrup", 30));
        output = service.serveBeverage(new Beverage("masala_tea", ingredients));
        assertEquals("masala_tea is prepared", output);
    }

    @Test
    public void serveBeveragesNotSufficient() {
        BeverageService service = new BeverageService(coffeeMachine);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 50));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("sugar_syrup", 30));
        String output = service.serveBeverage(new Beverage("hot_tea", ingredients));
        assertEquals("hot_tea is prepared", output);
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 200));
        ingredients.add(new Ingredient("ginger_syrup", 80));
        ingredients.add(new Ingredient("sugar_syrup", 60));
        output = service.serveBeverage(new Beverage("masala_tea", ingredients));
        assertEquals("masala_tea cannot be prepared because ginger_syrup is not sufficient", output);
    }

    @Test
    public void serveBeveragesNotAvailable() {
        BeverageService service = new BeverageService(coffeeMachine);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 50));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("sugar_syrup", 30));
        String output = service.serveBeverage(new Beverage("hot_tea", ingredients));
        assertEquals("hot_tea is prepared", output);
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("hot_water", 200));
        ingredients.add(new Ingredient("hot_milk", 200));
        ingredients.add(new Ingredient("ginger_syrup", 40));
        ingredients.add(new Ingredient("green_mixture", 30));
        output = service.serveBeverage(new Beverage("masala_tea", ingredients));
        assertEquals("masala_tea cannot be prepared because green_mixture is not available", output);
    }

}
