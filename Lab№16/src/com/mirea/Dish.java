package com.mirea;

public final class Dish extends MenuItem {

    public Dish(String name, String description) {
        super(0.0, name, description);
    }

    public Dish(double cost, String name, String description) {
        super(cost, name, description);
    }
}
