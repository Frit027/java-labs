package laboratory;

public class Main {

    public static void main(String[] args) {
        Sofa sofa = new Sofa(45000, 27.5, 20, "Hoff","White", "Soft");
        Table table1 = new Table(7000, 5.6, 40, "IKEA","Brown", "Strong");
        Table table2 = new Table(8000, 11.5, 20, "IKEA","Brown", "Strong");
        Cupboard cupboard = new Cupboard(10000.4, 8, 15, "Stolplit","Black", "NotRoomy");

        FurnitureShop shop = new FurnitureShop("Metanit");
        shop.add(sofa);
        shop.add(table1);
        shop.add(table2);
        shop.add(cupboard);

        shop.display();

        shop.sell(table1);

        shop.display();
    }
}
