package main;

import beans.Beverage;
import beans.CoffeeMachine;
import beans.json.InputJson;
import service.BeverageService;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        InputJson inputJson = InputProcessor.readFile("input.json");
        CoffeeMachine coffeeMachine = InputProcessor.jsonToCoffeeMachine(inputJson.getMachine());
        ArrayList<Beverage> beverages = InputProcessor.jsonToBeverages(inputJson.getMachine());
        BeverageService beverageService = new BeverageService(coffeeMachine);
        beverageService.serveBeverages(beverages);
    }
}
