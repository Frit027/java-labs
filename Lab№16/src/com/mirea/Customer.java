package com.mirea;

public final class Customer {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;
    private final Customer MATURE_UNKNOWN_CUSTOMER;
    private final Customer NOT_MATURE_UNKNOWN_CUSTOMER;

    public Customer(String fName, String sName, int a, Address address) {
        this.firstName = fName;
        this.secondName = sName;
        this.age = a;
        this.address = address;
        MATURE_UNKNOWN_CUSTOMER = null;
        NOT_MATURE_UNKNOWN_CUSTOMER = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
