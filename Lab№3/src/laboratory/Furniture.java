package laboratory;

public abstract class Furniture {
    private double price;
    private double weight;
    private int lifeTime;
    private String brand;
    private String color;

    public Furniture(double price, double weight, int lifeTime, String brand, String color) {
        this.price = price;
        this.weight = weight;
        this.lifeTime = lifeTime;
        this.brand = brand;
        this.color = color;
    }

    public String getDisplayName() {
        return this.getClass().getSimpleName();
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void display(){
        System.out.println("Price: " + getPrice()
                + "\nWeight: " + getWeight()
                + "\nLifetime: " + getLifeTime()
                + "\nBrand: " + getBrand()
                + "\nColor: " + getColor());
    }
}
