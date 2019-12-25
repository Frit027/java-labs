package com.mirea;

public final class Address {
    private final String cityName;
    private final int zipCode;
    private final String streetName;
    private final int buildingNumber;
    private final char buildingLetter;
    private final int apartmentNumber;
    private final Address EMPTY_ADDRESS;

    public Address(String city, int zip, String street,
                   int bNum, char bLet, int apprtNum) {
        this.cityName = city;
        this.zipCode = zip;
        this.streetName = street;
        this.buildingNumber = bNum;
        this.buildingLetter = bLet;
        this.apartmentNumber = apprtNum;
        EMPTY_ADDRESS = null;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
