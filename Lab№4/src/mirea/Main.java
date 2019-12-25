package mirea;

public class Main {

    public static void main(String[] args) {
        Planet mars = new Planet("Mars", 6.39E23);
        Planet venera = new Planet("Venera", 4.867E24);

        Car bmw = new Car("BMW X6", 250);
        Car ford = new Car("Ford Explorer", 190);

        System.out.println(mars.getName());
        System.out.println(venera.getName());

        System.out.println(bmw.getName());
        System.out.println(ford.getName());
    }
}
