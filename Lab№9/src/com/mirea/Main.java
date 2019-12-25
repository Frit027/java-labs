package com.mirea;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Exception1.exceptionDemo();                // Задание 1-4

        //ThrowsDemo.printMessage(null);        // Задание 5
        //ThrowsDemo.printMessage("me");

        //ThrowsDemo.getKey();                       // Задание 6
        ThrowsDemo.getKey();                       // Задание 7-8
    }
}

class Exception1 {
    public static void exceptionDemo() {

        /*Задание 1*/
        try {
            System.out.println(2 / 0);
        } catch(ArithmeticException ex) {
            System.out.println("Attempted division by zero");
        }

        /*Задание 2*/

        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        String intStr = myScanner.next();

        try {
            int i = Integer.parseInt(intStr);
            System.out.println(2 / i);
        }
        catch (Exception ex) {                          // Задание 3
            System.out.println("All exceptions are here.");
        }
        /*catch(ArithmeticException ex) {
            System.out.println("Attempted division by zero.");
        } catch(NumberFormatException ex) {
            System.out.println("Wrong type.");
        } finally {                                         // Задание 4
            System.out.println("Always it is here.");
        }*/
    }
}