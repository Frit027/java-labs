package mirea;

public class Car implements Nameable {
    private String name;
    private int maxSpeed;

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String getName() {
        return name;
    }
}
