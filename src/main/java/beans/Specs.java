package beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Specs {
    private ArrayList<Outlet> outlets;
    private HashMap<String, IngredientContainer> containers; // Container stores the food material

    public Specs(ArrayList<Outlet> outlets, HashMap<String, IngredientContainer> containers) {
        this.outlets = outlets;
        this.containers = containers;
    }

    public ArrayList<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(ArrayList<Outlet> oulets) {
        this.outlets = oulets;
    }

    public HashMap<String, IngredientContainer> getContainers() {
        return containers;
    }

    public void setContainers(HashMap<String, IngredientContainer> containers) {
        this.containers = containers;
    }
}
