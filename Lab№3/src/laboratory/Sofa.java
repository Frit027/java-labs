package laboratory;

public class Sofa extends Furniture {
    private String softness;

    public Sofa(double price, double weight, int lifeTime, String brand, String color, String softness){
        super(price, weight, lifeTime, brand, color);
        this.softness = softness;
    }

    public void setSoftness(String softness) {
        this.softness = softness;
    }

    @Override
    public void display() {
        System.out.println("Type: " + this.getClass().getSimpleName());
        super.display();
        System.out.println("Softness: " + softness + "\n");
    }
}
