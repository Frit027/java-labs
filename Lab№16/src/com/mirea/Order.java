package com.mirea;

public interface Order {
    boolean add(MenuItem item);
    boolean removeItem(String itemName);
    int removeAll(String itemName);

    int quantity();
    double costTotal();
    int itemQuantity(String itemName);

    MenuItem[] getItems();
    MenuItem[] sortedItemsByCostDesc();
    String[] dishesAndDrinksNames();

    Customer getCustomer();
    void setCustomer(Customer customer);
}
