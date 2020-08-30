package beans.json;

import java.util.HashMap;

public class Machine {
    private Outlet outlets;
    private HashMap<String, Integer> total_items_quantity;
    private HashMap<String, HashMap<String, Integer>> beverages;
    private HashMap<String, Integer> beveragess;


    public Outlet getOutlets() {
        return outlets;
    }

    public void setOutlets(Outlet outlets) {
        this.outlets = outlets;
    }

    public HashMap<String, Integer> getTotal_items_quantity() {
        return total_items_quantity;
    }

    public void setTotal_items_quantity(HashMap<String, Integer> total_items_quantity) {
        this.total_items_quantity = total_items_quantity;
    }

    public HashMap<String, HashMap<String, Integer>> getBeverages() {
        return beverages;
    }

    public void setBeverages(HashMap<String, HashMap<String, Integer>> beverages) {
        this.beverages = beverages;
    }
}
