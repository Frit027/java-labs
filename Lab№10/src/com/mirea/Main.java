package com.mirea;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        /*Task 1*/
        System.out.println("ЗАДАНИЕ 1");

        Integer[] arrInt = {1, 2, 3, 4, 5, 6};
        String[] arrStr = {"C", "C++", "C#"};

        ArrayList<Integer> listInt = conversion(arrInt);
        ArrayList<String> listStr = conversion(arrStr);

        System.out.println(listInt);
        System.out.println(listStr);

        /*Task 4*/
        System.out.println("ЗАДАНИЕ 4");

        File file = new File("C:\\Users\\user\\Documents\\Laboratory_works. Java\\Lab№10");
        ArrayList<String> list = getList(file);

        System.out.println(list);

        /*Task 5*/
        System.out.println("ЗАДАНИЕ 5");

        ArrayList<String> arrayList = Solution.newArrayList("Dog", "Cat", "Horse");

        HashSet<String> hashSet = Solution.newHashSet("Table", "Desk", "Chair");

        HashMap<Integer, String> hashMap = Solution.newHashMap(
                new Solution.Pair<>(234, "Name1"),
                new Solution.Pair<>(653, "Name2"),
                new Solution.Pair<>(804, "Name3")
        );

        System.out.println(arrayList);
        System.out.println(hashSet);
        System.out.println(hashMap);
    }

    private static <E> ArrayList<E> conversion(E[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    private static ArrayList<String> getList(File file){
        ArrayList<String> list = new ArrayList<>(Arrays.asList(file.list()));
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                res.add(list.get(i));
            } catch(IndexOutOfBoundsException ex) {
                ex.getMessage();
            }
        }
        return res;
    }
}