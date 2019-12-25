package com.mirea;

public class MenuItem {
    private double COST;
    private String NAME;
    private String DESCRIPTION;

    public MenuItem() { }

    public MenuItem(double cost, String name, String description) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be less than zero.");
        }
        checkString(name, description);
        this.NAME = name;
        this.DESCRIPTION = description;
        this.COST = cost;
    }

    public double getCOST() {
        return COST;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getNAME() {
        return NAME;
    }

    private void checkString(String ... arr) {
        for (String str : arr) {
            if (str.length() == 0) {
                throw new IllegalArgumentException("The string should not be empty.");
            }
        }
    }
}
