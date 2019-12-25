package laboratory;

public class Cupboard extends Furniture {
    private String spaciousness;

    public Cupboard(double price, double weight, int lifeTime, String brand, String color, String spaciousness){
        super(price, weight, lifeTime, brand, color);
        this.spaciousness = spaciousness;
    }

    public void setSpaciousness(String spaciousness) {
        this.spaciousness = spaciousness;
    }

    @Override
    public void display() {
        System.out.println("Type: " + this.getClass().getSimpleName());
        super.display();
        System.out.println("Spaciousness: " + spaciousness + "\n");
    }
}
