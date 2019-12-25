package com.mirea;

import java.util.Scanner;

class ThrowsDemo {
    /*ЗАДАНИЕ 5*/
    /*public static void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    public static String getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
        } catch(NullPointerException ex) {
            System.out.println(("NullPointerException was discovered."));
        }

        return "data for " + key;
    }*/

    /*ЗАДАНИЕ 6*/
    /*public static void getKey() {
        Scanner myScanner = new Scanner(System.in);

        String key = myScanner.next();
        try {
            printDetails(key);
        } catch (Exception ex) {
            System.out.println("Catch!");
        }
    }

    public static void printDetails(String key) throws Exception {
            String message = getDetails(key);
            System.out.println(message);
    }

    private static String getDetails(String key) throws Exception {
        if(key.equals("f")) {
            throw new Exception("Key set to empty string");
        }

        return "data for " + key;
    }*/

    /*ЗАДАНИЕ 7-8*/
    public static void getKey() {
        boolean flag = true;
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter Key: ");

        while(flag) {
            try {
                String key = myScanner.nextLine();
                printDetails(key);

                flag = false;
            } catch (Exception ex) {
                System.out.println("Error.");
            }
        }
    }

    public static void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private static String getDetails(String key) throws Exception {
        if(key.equals("f")) {
            throw new Exception("Key set to empty string");
        }

        return "data for " + key;
    }
}
