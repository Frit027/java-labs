package com.mirea;

public class RestaurantOrder implements Order{
    private int sizeDish;
    private int sizeDrink;
    private Dish[] dishes;
    private Drink[] drinks;
    private Customer customer;

    public RestaurantOrder() {
        dishes = new Dish[0];
        drinks = new Drink[0];
        sizeDrink = 0;
        sizeDish = 0;
    }

    public RestaurantOrder(Dish[] dishes, Drink[] drinks) {
        this.dishes = dishes;
        this.drinks = drinks;
        sizeDish = this.dishes.length;
        sizeDrink = this.drinks.length;
    }

    @Override
    public boolean add(MenuItem item) {
        if (item instanceof Drink) {
            sizeDrink++;
            Drink[] arr = drinks;
            drinks = new Drink[sizeDrink];

            System.arraycopy(arr, 0, drinks, 0, arr.length);
            drinks[arr.length] = (Drink) item;
        } else {
            sizeDish++;
            Dish[] arr = dishes;
            dishes = new Dish[sizeDish];

            System.arraycopy(arr, 0, dishes, 0, arr.length);
            dishes[arr.length] = (Dish) item;
        }
        return true;
    }

    @Override
    public boolean removeItem(String itemName) {
        if (isContainInDishes(itemName) != 0) {
            if(sizeDish == 0) {
                return false;
            }

            sizeDish--;
            Dish[] arr = new Dish[sizeDish];

            int j = 0;
            for (Dish dish : dishes) {
                if (!dish.getNAME().equals(itemName)) {
                    arr[j] = dish;
                    j++;
                }
            }

            if(j == dishes.length) {
                return false;
            }
            dishes = new Dish[sizeDish];
            System.arraycopy(arr, 0, dishes, 0, sizeDish);
        } else if (isContainInDrinks(itemName) != 0) {
            if(sizeDrink == 0) {
                return false;
            }

            sizeDrink--;
            Drink[] arr = new Drink[sizeDrink];

            int j = 0;
            for (Drink drink : drinks) {
                if (!drink.getNAME().equals(itemName)) {
                    arr[j] = drink;
                    j++;
                }
            }

            if(j == drinks.length) {
                return false;
            }
            drinks = new Drink[sizeDrink];
            System.arraycopy(arr, 0, drinks, 0, sizeDrink);
        } else {
            return false;
        }

        return true;
    }

    @Override
    public int removeAll(String itemName) {
        if (isContainInDishes(itemName) != 0) {
            return removeAllDishes(itemName);
        } else if (isContainInDrinks(itemName) != 0) {
            return removeAllDrinks(itemName);
        } else {
            return 0;
        }
    }

    private int removeAllDishes(String dishName) {
        if(sizeDish == 0) {
            return 0;
        }

        int k = dishQuantity(dishName);
        sizeDish -= k;
        Dish[] arr = new Dish[sizeDish];
        int i = 0;
        for (Dish dish : dishes) {
            if (!dish.getNAME().equals(dishName)) {
                arr[i] = dish;
                i++;
            }
        }

        dishes = new Dish[sizeDish];
        dishes = arr;

        return k;
    }

    private int removeAllDrinks(String drinkName) {
        if(sizeDrink == 0) {
            return 0;
        }

        int k = drinkQuantity(drinkName);
        sizeDrink -= k;
        Drink[] arr = new Drink[sizeDrink];
        int i = 0;
        for (Drink drink : drinks) {
            if (!drink.getNAME().equals(drinkName)) {
                arr[i] = drink;
                i++;
            }
        }

        drinks = new Drink[sizeDrink];
        drinks = arr;

        return k;
    }

    @Override
    public int quantity() {
        return dishes.length + drinks.length;
    }

    public int dishQuantity() {
        return sizeDish;
    }

    public int drinkQuantity() {
        return sizeDrink;
    }

    @Override
    public int itemQuantity(String itemName) {
        if (isContainInDishes(itemName) != 0) {
            return dishQuantity(itemName);
        } else if (isContainInDrinks(itemName) != 0) {
            return drinkQuantity(itemName);
        } else {
            return 0;
        }
    }

    private int dishQuantity(String dishName) {
        int i = 0;
        for(Dish dish : dishes) {
            if (dish.getNAME().equals(dishName)) {
                i++;
            }
        }
        return i;
    }

    private int drinkQuantity(String drinkName) {
        int i = 0;
        for(Drink drink : drinks) {
            if (drink.getNAME().equals(drinkName)) {
                i++;
            }
        }
        return i;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[sizeDish + sizeDrink];
        System.arraycopy(dishes, 0, items, 0, sizeDish);
        System.arraycopy(drinks, 0, items, sizeDish, sizeDrink);

        return items;
    }

    @Override
    public double costTotal() {
        double res = 0.0;

        for (Dish dish : dishes) {
            res += dish.getCOST();
        }
        for (Drink drink : drinks) {
            res += drink.getCOST();
        }
        return res;
    }

    private int isContainInDishes(String name) {
        int k = 0;
        for(Dish dish : dishes) {
            if (dish.getNAME().equals(name)) {
                k++;
            }
        }
        return k;
    }

    private int isContainInDrinks(String name) {
        int k = 0;
        for(Drink drink : drinks) {
            if (drink.getNAME().equals(name)) {
                k++;
            }
        }

        return k;
    }

    private boolean isContainInNames(String name, String[] arr) {
        for (String str : arr) {
            if(str != null) {
                if (str.equals(name)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String[] dishesAndDrinksNames() {
        int k = 0, rep = 0;

        for(Drink drink : drinks) {
            if (isContainInDrinks(drink.getNAME()) == 1) {
                k++;
            } else {
                rep++;
            }
        }
        rep = (int)Math.ceil(rep / 2);

        int rep2 = 0;
        for(Dish dish : dishes) {
            if (isContainInDishes(dish.getNAME()) == 1) {
                k++;
            } else {
                rep2++;
            }
        }
        rep2 = (int)Math.ceil(rep2 / 2);

        String[] names = new String[k + rep + rep2];
        int i = 0;
        for(Drink drink : drinks) {
            if (isContainInNames(drink.getNAME(), names)) {
                names[i] = drink.getNAME();
                i++;
            }
        }
        for(Dish dish : dishes) {
            if (isContainInNames(dish.getNAME(), names)) {
                names[i] = dish.getNAME();
                i++;
            }
        }

        return names;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = new MenuItem[sizeDrink + sizeDish];
        System.arraycopy(dishes, 0, items, 0, sizeDish);
        System.arraycopy(drinks, 0, items, sizeDish, sizeDrink);

        for (int i = 1; i < items.length; i++) {
            for (int j = i; j > 0; j--) {
                if (items[j].getCOST() < items[j - 1].getCOST()) {
                    MenuItem temp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = temp;
                }
            }
        }

        return items;
    }

    public void show() {
        int i = 1;

        for (Dish dish : dishes) {
            if (dish != null) {
                System.out.println("Dish " + i + ": "
                        + dish.getCOST() + " " + dish.getNAME() + " " + dish.getDESCRIPTION());
                i++;
            }
        }
        System.out.println();
        i = 1;
        for (Drink drink : drinks) {
            if (drink != null) {
                System.out.println("Drink " + i + ": "
                        + drink.getCOST() + " " + drink.getNAME() + " " + drink.getDESCRIPTION() + " "
                        + drink.getType() + " " + drink.getAlcoholVol());
                i++;
            }
        }
    }

    @Override
    public void setCustomer(Customer customer) {
        customer = new Customer(customer.getFirstName(), customer.getSecondName(), customer.getAge(), customer.getAddress());
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }
}
