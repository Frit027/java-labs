package laboratory;

public class Table extends Furniture {
    private String strength;

    public Table(double price, double weight, int lifeTime, String brand, String color, String strength){
        super(price, weight, lifeTime, brand, color);
        this.strength = strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    @Override
    public void display() {
        System.out.println("Type: " + this.getClass().getSimpleName());
        super.display();
        System.out.println("Strength: " + strength + "\n");
    }
}
