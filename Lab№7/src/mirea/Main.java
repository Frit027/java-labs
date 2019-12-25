package mirea;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*Задание 1*/
        System.out.println("ЗАДАНИЕ 1");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);
        numbers.add(400);

        System.out.println(numbers.get(1));
        numbers.remove(1);
        System.out.println(numbers.contains(200));
        numbers.set(0, 999);
        System.out.println(numbers.toString());
        System.out.println(numbers.isEmpty());

        /*Задание 2*/
        System.out.println("ЗАДАНИЕ 2");

        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        list.remove(3);
        System.out.println(list.toString());

        list.addFirst('!');
        list.addLast('?');
        System.out.println(list.peekFirst());
        System.out.println(list.pollLast());

        Character[] arr = list.toArray(new Character[5]);
        System.out.println(Arrays.toString(arr));

        System.out.println(list.pop());

        Iterator it = list.descendingIterator();
        while(it.hasNext())
            System.out.print(" " + it.next());

        list.clear();

        /*Задание 3*/
        System.out.println("\nЗАДАНИЕ 3");

        System.out.println("MyArrayList");

        MyArrayList<String> myList = new MyArrayList<>();
        myList.add("Cat");
        myList.add("Dog");
        myList.add("Bird");
        myList.add("Lion");
        myList.add("Duck");
        myList.add("Mouse");
        MyArrayList<Integer> list2 = new MyArrayList<>(numbers);

        myList.show();
        list2.show();

        System.out.println(myList.get(1) + '\n');
        myList.remove(2);
        myList.show();
        myList.add(2, "Elephant");
        myList.add(6, "Cow");
        myList.show();

        LinkedList<String> linkedList = new LinkedList<>(myList.subList(2,7));
        linkedList.forEach(System.out::println);

        System.out.println(myList.isEmpty());
    }
}
