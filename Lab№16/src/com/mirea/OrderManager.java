package com.mirea;

import java.util.HashMap;

public class OrderManager {
    private RestaurantOrder[] orders;
    private HashMap<Address, RestaurantOrder> hashMap;

    public OrderManager() {
        hashMap = new HashMap<>();
        orders = new RestaurantOrder[20];
    }

    public void add(Address address, RestaurantOrder order) throws OrderAlreadyAddedException {
        checkAddress(address);
        hashMap.put(address, order);
    }

    public void add(RestaurantOrder order, int tableNumber) throws OrderAlreadyAddedException {
        checkTableNumber(tableNumber);
        orders[tableNumber] = order;
    }

    public void addItem(MenuItem item, int tableNumber) throws OrderAlreadyAddedException {
        checkTableNumber(tableNumber);
        orders[tableNumber].add(item);
    }

    public void addItem(Address address, MenuItem item) throws OrderAlreadyAddedException {
        checkAddress(address);
        hashMap.get(address).add(item);
    }

    public RestaurantOrder getOrder(int tableNumber) {
        return orders[tableNumber];
    }

    public RestaurantOrder getOrder(Address address) {
        return hashMap.get(address);
    }

    public void removeOrder(int tableNumber) {
        orders[tableNumber] = null;
    }

    public void removeOrder(Address address) {
        hashMap.remove(address);
    }

    public Order[] getInternetOrders(){
        Order[] ordersList = new Order[hashMap.size()];
        int index = 0;
        for (Address address : hashMap.keySet()){
            ordersList[index] = hashMap.get(address);
        }
        return ordersList;
    }

    public double internetOrdersCostSummary(){
        int cost = 0;
        for (Order order : getInternetOrders()){
            cost += order.costTotal();
        }
        return cost;
    }

    public int internetItemQuantity(String itemName){
        int quantity = 0;
        for (Order order : getInternetOrders()){
            quantity += order.itemQuantity(itemName);
        }
        return quantity;
    }

    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return i + 1;
            }
        }
        return 0;
    }

    public int[] freeTableNumbers() {
        int k = 0;
        for (RestaurantOrder order : orders) {
            if (order == null) {
                k++;
            }
        }

        int[] arr = new int[k];
        int j = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                arr[j] = i;
                j++;
            }
        }

        return arr;
    }

    public RestaurantOrder[] getOrders() {
        return orders;
    }

    public double orderCostSummary() {
        double res = 0.0;

        for (RestaurantOrder order : orders) {
            if (order != null) {
                res += order.costTotal();
            }
        }

        return res;
    }

    public int dishQuantity(String dishName) {
        int res = 0;
        for (RestaurantOrder order : orders) {
            if (order != null) {
                res += order.itemQuantity(dishName);
            }
        }

        return res;
    }

    public void show() {
        for (RestaurantOrder order : orders) {
            if (order != null) {
                order.show();
            }
        }
    }

    private void checkAddress(Address address) throws OrderAlreadyAddedException {
        if (hashMap.get(address) != null) {
            throw new OrderAlreadyAddedException("An order has already been associated with this address.");
        }
    }

    private void checkTableNumber(int tableNumber) throws OrderAlreadyAddedException {
        if (tableNumber < 0 || tableNumber > 19) {
            throw new IllegalTableNumber("This table does not exist.");
        }
        if (orders[tableNumber] != null) {
            throw new OrderAlreadyAddedException("An order has already been associated with this table.");
        }
    }
}
