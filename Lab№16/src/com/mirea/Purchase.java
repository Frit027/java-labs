package com.mirea;

import java.util.Scanner;

public class Purchase {
    private Scanner in = new Scanner(System.in);
    private Customer human;
    private Address address;
    private RestaurantOrder restaurantOrder;
    private InternetOrder internetOrder;
    private OrderManager manager;
    private Dish[] dishes;
    private Drink[] drinks;

    public Purchase() {
        Dish dish1 = new Dish(10.0, "NameDish1", "Description1");
        Dish dish2 = new Dish(20.0, "NameDish2", "Description2");
        Dish dish3 = new Dish(30.0, "NameDish3", "Description3");
        Dish dish4 = new Dish(40.0, "NameDish4", "Description4");
        Dish dish5 = new Dish(50.0, "NameDish5", "Description5");

        Drink drink1 = new Drink(1.5, "NameDrink1", "Description1", DrinkTypeEnum.GREEN_TEA, 0.0);
        Drink drink2 = new Drink(2.5, "NameDrink2", "Description2", DrinkTypeEnum.BLACK_TEA, 0.0);
        Drink drink3 = new Drink(3.5, "NameDrink3", "Description3", DrinkTypeEnum.BEER, 4.5);
        Drink drink4 = new Drink(4.5, "NameDrink4", "Description4", DrinkTypeEnum.JAGERMEISTER, 35.0);
        Drink drink5 = new Drink(5.5, "NameDrink5", "Description5", DrinkTypeEnum.VERMOUTH, 16.0);

        dishes = new Dish[]{dish1, dish2, dish3, dish4, dish5};
        drinks = new Drink[]{drink1, drink2, drink3, drink4, drink5};
    }

    private String enter(String data) {
        System.out.print(data);
        return in.nextLine();
    }

    private Address enterAddress() {
        String city = enter("Your city: ");
        int zipCode = Integer.parseInt(enter("Your zip code: "));
        String street = enter("Your street: ");
        int buildingNumber = Integer.parseInt(enter("Your number of building: "));
        char buildingLetter = enter("Your letter of building: ").charAt(0);
        int apartmentNumber = Integer.parseInt(enter("Your number of flat: "));

        return new Address(city, zipCode, street, buildingNumber, buildingLetter, apartmentNumber);
    }

    public void enterCustomerAndAddress() {
        String name = enter("Your first name: ");
        String lastName = enter("Your last name: ");
        int age = Integer.parseInt(enter("Your age: "));

        address = enterAddress();
        human = new Customer(name, lastName, age, address);
    }

    public void typeOfOrder() {
        System.out.println("Select the type of order (0 - booking a table in a restaurant, 1 - Internet order): ");
        int choice = in.nextInt();

        if (choice == 1) {
            chooseFoodForInternetOrder();
            actionInternetOrder();
        } else {
            chooseFoodForRestaurantOrder();
            actionRestaurantOrder();
        }
    }

    private void actionInternetOrder() {
        internetOrder.setCustomer(human);

        System.out.println("Your order: ");
        internetOrder.show();

        System.out.println("Your final price: ");
        System.out.println(internetOrder.costTotal());

        System.out.println("Do you want to add something? (0 - no, 1 - yes)");
        int choice = in.nextInt();
        if (choice == 1) {
            System.out.println("Dish or drink? (0 - drink, 1 - dish)");
            int choiceItem = in.nextInt();

            if (choiceItem == 1) {
                System.out.println("Enter number of dish to add it in order: ");
                int j = in.nextInt();
                internetOrder.add(dishes[j - 1]);
            }
            else {
                System.out.println("Enter number of drink to add it in order: ");
                int j = in.nextInt();
                internetOrder.add(drinks[j - 1]);
            }
        }

        internetOrder.show();
        System.out.println("Do you want to remove something? (0 - no, 1 - yes)");
        choice = in.nextInt();
        in.nextLine();

        if (choice == 1) {
            System.out.print("Enter name of item to remove in the order: ");
            String name = in.nextLine();
            internetOrder.removeItem(name);
        }
        internetOrder.show();
    }

    private void actionRestaurantOrder() {
        restaurantOrder.setCustomer(human);

        System.out.println("Your order: ");
        restaurantOrder.show();

        System.out.println("Your final price: ");
        System.out.println(restaurantOrder.costTotal());

        System.out.println("Do you want to add something? (0 - no, 1 - yes)");
        int choice = in.nextInt();
        if (choice == 1) {
            System.out.println("Dish or drink? (0 - drink, 1 - dish)");
            int choiceItem = in.nextInt();

            if (choiceItem == 1) {
                System.out.println("Enter number of dish to add it in order: ");
                int j = in.nextInt();
                restaurantOrder.add(dishes[j - 1]);
            }
            else {
                System.out.println("Enter number of drink to add it in order: ");
                int j = in.nextInt();
                restaurantOrder.add(drinks[j - 1]);
            }
        }

        restaurantOrder.show();
        System.out.println("Do you want to remove something? (0 - no, 1 - yes)");
        choice = in.nextInt();
        in.nextLine();

        if (choice == 1) {
            System.out.print("Enter name of item to remove in the order: ");
            String name = in.nextLine();
            restaurantOrder.removeItem(name);
        }
        restaurantOrder.show();

        manager = new OrderManager();

        int k = manager.freeTableNumber();
        System.out.println("Free table №" + k);
        try {
            manager.add(restaurantOrder, k);
        } catch (OrderAlreadyAddedException ex) {
            ex.getMessage();
        }
        System.out.println("Cost price: " + manager.orderCostSummary());
        manager.show();
    }

    private void chooseFoodForInternetOrder() {
        showMenu();
        internetOrder = new InternetOrder();

        System.out.println("Choose your food: ");
        System.out.println("Enter number of dish to add in the order (0 - exit): ");

        int choice = in.nextInt();
        while (choice != 0) {
            internetOrder.add(dishes[choice - 1]);
            choice = in.nextInt();
        }

        System.out.println("Enter number of drink to add in the order (0 - exit): ");

        choice = in.nextInt();
        while (choice != 0) {
            internetOrder.add(drinks[choice - 1]);
            choice = in.nextInt();
        }
    }

    private void chooseFoodForRestaurantOrder() {
        showMenu();
        restaurantOrder = new RestaurantOrder();

        System.out.println("Choose your food: ");
        System.out.println("Enter number of dish to add in the order (0 - exit): ");

        int choice = in.nextInt();
        while (choice != 0) {
            restaurantOrder.add(dishes[choice - 1]);
            choice = in.nextInt();
        }

        System.out.println("Enter number of drink to add in the order (0 - exit): ");

        choice = in.nextInt();
        while (choice != 0) {
            restaurantOrder.add(drinks[choice - 1]);
            choice = in.nextInt();
        }
    }

    private void showMenu() {
        System.out.println("Our menu: ");

        int j = 1;
        for (Dish dish : dishes) {
            System.out.println("Dish " + j + ": "
                    + dish.getCOST() + " " + dish.getNAME() + " " + dish.getDESCRIPTION());
            j++;
        }
        System.out.println();
        j = 1;
        for (Drink drink : drinks) {
            System.out.println("Drink " + j + ": "
                    + drink.getCOST() + " " + drink.getNAME() + " " + drink.getDESCRIPTION() + " "
                    + drink.getType() + " " + drink.getAlcoholVol());
            j++;
        }
    }
}
