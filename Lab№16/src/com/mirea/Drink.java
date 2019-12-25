package com.mirea;

public final class Drink extends MenuItem implements Alcoholable {
    private final DrinkTypeEnum type;
    private final double alcoholVol;

    public Drink(String name, String description, DrinkTypeEnum type, double vol) {
        super(0.0, name, description);
        this.type = type;
        alcoholVol = vol;
    }

    public Drink(double cost, String name, String description, DrinkTypeEnum type, double vol) {
        super(cost, name, description);
        this.type = type;
        alcoholVol = vol;
    }

    @Override
    public boolean isAlcoholicDrink() {
        if (alcoholVol > 4.0) {
            return true;
        }
        return false;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }
}
