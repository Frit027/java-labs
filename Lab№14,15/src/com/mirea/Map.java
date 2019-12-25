package com.mirea;

import java.util.*;

public class Map {
    private HashMap<String, LinkedList<String>> hashMap;

    public Map() { }

    public HashMap createMap(String ... peoples) {
        hashMap = new HashMap<>();

        for (String student : peoples) {
            String[] names = student.split("\\s");
            LinkedList<String> list = new LinkedList<>();

            if  (hashMap.containsKey(names[0])) {
                list.addAll(hashMap.get(names[0]));
                list.add(names[1]);
                hashMap.put(names[0], list);
            } else {
                list.add(names[1]);
                hashMap.put(names[0], list);
            }
        }

        return hashMap;
    }

    public int getSameFirstNameCount(String name) {
        int k = 1, max = 0, res = 0;
        ArrayList<String> names = new ArrayList<>();

        for (String lastName : hashMap.keySet()) {
            for (String firstName : hashMap.get(lastName)) {
                if (firstName.equals(name)) {
                    res++;
                }
            }
        }

        /*for (String lastName : hashMap.keySet()) {
            names.addAll(hashMap.get(lastName));
        }

        for (int i = 0; i < names.size(); i++) {
            if (!names.get(i).equals("")) {
                for (int j = i + 1; j < names.size(); j++) {
                    if (names.get(i).equals(names.get(j))) {
                        k++;
                        names.remove(names.get(j));
                        names.add(j, "");
                    }
                }
            }

            if (k > max) {
                max = k;
            }
            k = 1;
        }*/

        return res;
    }

    public int getSameLastNameCount(String secondName) {
        int max = 0, count;

        for (String lastName : hashMap.keySet()) {
            if (lastName.equals(secondName)) {
                return hashMap.get(lastName).size();
            }
        }
        return 0;
        /*for (String lastName : hashMap.keySet()) {
            count = hashMap.get(lastName).size();
            if (count > max) {
                max = count;
            }
        }

        return max;*/
    }

    public void print() {
        System.out.println(hashMap);
    }
}
