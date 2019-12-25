package com.mirea;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        /*Task 1*/
		System.out.println("ЗАДАНИЕ 1");

	    Set<String> hashSet = new HashSet<>() {{
			add("word");
			add("apple");
			add("car");
			add("black");
			add("yellow");
		}};

        System.out.println("HashSet: " + hashSet);

        Set<String> treeSet = new TreeSet<>(hashSet);
        System.out.println("TreeSet: " + treeSet);

		/*Task 2*/
		System.out.println("ЗАДАНИЕ 2");

		Map map = new Map();
		map.createMap("LastName1 Name1", "LastName2 Name2",
					"LastName1 Name3", "LastName4 Name4",
					"LastName1 Name5", "LastName6 Name1",
					"LastName7 Name1", "LastName8 Name8",
					"LastName1 Name9", "LastName10 Name2");

		map.print();
		System.out.println(map.getSameFirstNameCount("Name1"));
		System.out.println(map.getSameLastNameCount("LastName1"));

		/*Task 3*/
		System.out.println("ЗАДАНИЕ 3");

		HashTable<Double, Integer> hashTable = new HashTable<>(4) {{
			put(34.5, 99);
			put(70.1, 10);
			put(81.43, 20);
			put(56.21, 30);
		}};

		hashTable.printTable();

		System.out.println(hashTable.get(34.5));
		System.out.println(hashTable.get(81.43));
		System.out.println(hashTable.get(70.1));
		System.out.println(hashTable.get(56.21));

		hashTable.remove(34.5);
		hashTable.printTable();
    }
}
