package com.mirea;

public class InternetOrder implements Order {
    private MyLinkedList<MenuItem> items = new MyLinkedList<>();
    private Customer customer;

    public InternetOrder() { }

    public InternetOrder(MenuItem[] items) {
        for(MenuItem item : items){
            this.items.addNode(item);
        }
    }

    @Override
    public boolean add(MenuItem item) {
        items.addNode(item);
        return true;
    }

    @Override
    public boolean removeItem(String name) {
        MenuItem[] itemsList = items.asArray();
        for(MenuItem item : itemsList){
            if (item.getNAME().equals(name)) {
                items.deleteNode(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String name) {
        int quantity = 0;
        while(removeItem(name)){
            quantity++;
        }
        return quantity;
    }

    @Override
    public int quantity() {
        return items.size();
    }

    @Override
    public int itemQuantity(String name) {
        int quantity = 0;
        MenuItem[] itemsList = items.asArray();
        for(MenuItem item : itemsList){
            if (item.getNAME().equals(name)){
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public MenuItem[] getItems() {
        return items.asArray().clone();
    }

    @Override
    public double costTotal() {
        double cost = 0;
        MenuItem[] itemsList = items.asArray();
        for(MenuItem item : itemsList){
            cost += item.getCOST();
        }
        return cost;
    }

    @Override
    public String[] dishesAndDrinksNames() {
        MenuItem[] itemsList = items.asArray();
        String[] itemsNames = new String[itemsList.length];

        for (int i = 0; i < itemsNames.length; i++) {
            itemsNames[i] = itemsList[i].getNAME();
        }
        return itemsNames.clone();
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] itemsList = items.asArray().clone();

        for (int i = 1; i < itemsList.length; i++) {
            for (int j = i; j > 0; j--) {
                if (itemsList[j].getCOST() > itemsList[j - 1].getCOST()) {
                    MenuItem temp = itemsList[j];
                    itemsList[j] = itemsList[j - 1];
                    itemsList[j - 1] = temp;
                }
            }
        }
        return itemsList;
    }

    public void show() {
        int i = 1;
        for(MenuItem item : items.asArray()) {
            if (item != null) {
                System.out.println("Item " + i + ": "
                        + item.getCOST() + " " + item.getNAME() + " " + item.getDESCRIPTION());
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
