package laboratory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FurnitureShop {
    private String title;
    private ArrayList<Furniture> stock;
    private Map<String, Integer> count;
    private double profit;

    public FurnitureShop(String title) {
        this.title = title;
        stock = new ArrayList<>();
        count = new HashMap<>();
    }

    public void add(Furniture furniture) {
        stock.add(furniture);
        String name = furniture.getDisplayName();

        if(count.containsKey(name)){
            int k = count.get(name);
            count.put(name, ++k);
        }
        else
            count.put(name, 1);
    }

    public void sell(Furniture furniture) {
        stock.remove(furniture);
        profit += furniture.getPrice();

        String name = furniture.getDisplayName();
        int k = count.get(name);
        count.put(name, --k);
    }

    public void display() {
        System.out.println("Title: " + title
                        + "\nProfit: " + profit);

        for(Map.Entry entry : count.entrySet())
            System.out.println("Type: " + entry.getKey() + ". Count: "
                    + entry.getValue());

        for(Furniture fur : stock)
            fur.display();
    }
}
