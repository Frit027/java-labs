package com.mirea;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*Dish dish1 = new Dish(10.0, "NameDish1", "Description1");
        Dish dish2 = new Dish(20.0, "NameDish2", "Description2");
        Dish dish3 = new Dish(30.0, "NameDish3", "Description3");
        Dish dish4 = new Dish(40.0, "NameDish4", "Description4");
        Dish dish5 = new Dish(50.0, "NameDish5", "Description5");

        Drink drink1 = new Drink(1.5, "NameDrink1", "Description1", DrinkTypeEnum.GREEN_TEA, 0.0);
        Drink drink2 = new Drink(2.5, "NameDrink2", "Description2", DrinkTypeEnum.BLACK_TEA, 0.0);
        Drink drink3 = new Drink(3.5, "NameDrink3", "Description3", DrinkTypeEnum.BEER, 4.5);
        Drink drink4 = new Drink(4.5, "NameDrink4", "Description4", DrinkTypeEnum.JAGERMEISTER, 35.0);
        Drink drink5 = new Drink(5.5, "NameDrink5", "Description5", DrinkTypeEnum.VERMOUTH, 16.0);

        Dish[] dishes = {dish1, dish2, dish3, dish4, dish5};
        Drink[] drinks = {drink1, drink2, drink3, drink4, drink5};

        Address address = new Address("Moscow", 170040, "pr. Vernadskogo", 63, 'a', 48);
        Customer man = new Customer("Ilya", "Yurov", 19, address);

        RestaurantOrder restaurantOrder = new RestaurantOrder(dishes, drinks);
        restaurantOrder.setCustomer(man);
        System.out.println(restaurantOrder.costTotal());
        System.out.println(restaurantOrder.dishQuantity());
        restaurantOrder.removeItem("NameDrink3");
        restaurantOrder.add(new Drink(2.0, "NameDrink3", "Description3", DrinkTypeEnum.MILK, 0.4));

        OrderManager manager = new OrderManager();
        try {
            manager.add(address, restaurantOrder);
        } catch (OrderAlreadyAddedException ex) {
            ex.getMessage();
        }

        manager.getOrder(address).show();

        InternetOrder internetOrder = new InternetOrder(dishes);
        System.out.println(internetOrder.costTotal());
        internetOrder.add(new Drink(2.4, "NameDrink6", "Description6", DrinkTypeEnum.COFFEE, 0.0));
        System.out.println(Arrays.toString(internetOrder.dishesAndDrinksNames()));*/

        Purchase purchase = new Purchase();
        purchase.enterCustomerAndAddress();
        purchase.typeOfOrder();
    }
}
