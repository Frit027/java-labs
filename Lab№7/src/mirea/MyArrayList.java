package mirea;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyArrayList<T> {
    private int size;
    private T[] arr;

    public MyArrayList() {
        size = 0;
        arr = (T[]) new Object[size];
    }

    public MyArrayList(Collection <? extends T> c) {
        size = c.size();
        arr = (T[]) c.toArray();
    }

    public void add(T element) {
        T[] arrTemp = arr.clone();

        size = arr.length + 1;
        arr = (T[]) new Object[size];
        System.arraycopy(arrTemp,0, arr,0, size-1);

        arr[size - 1] = element;
    }

    public void add(int index, T element) {
        checkIndexFirst(index);

        T[] arrTemp = arr.clone();

        size++;
        arr = (T[]) new Object[size];
        arr[index] = element;

        System.arraycopy(arrTemp, 0, arr, 0, index);
        System.arraycopy(arrTemp, index, arr, index + 1, arrTemp.length - index);
    }

    public T get(int index) {
        checkIndexSecond(index);
        return arr[index];
    }

    public void remove(int index) {
        checkIndexSecond(index);

        T[] arrTemp = arr.clone();

        size--;
        arr = (T[]) new Object[size];
        System.arraycopy(arrTemp, 0, arr, 0, index);
        System.arraycopy(arrTemp, index + 1, arr, index, size - index);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return !(size > 0);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        checkSublist(fromIndex, toIndex);

        T[] arrTemp = (T[]) new Object[toIndex - fromIndex];
        System.arraycopy(arr, fromIndex, arrTemp, 0, toIndex - fromIndex);

        return Arrays.asList(arrTemp);
    }

    public void show() {
        for (T t : arr)
            System.out.println(t);
        System.out.println();
    }

    private void checkIndexFirst(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
    }

    private void checkIndexSecond(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
    }

    private void checkSublist(int fromIndex, int toIndex) {
        if(fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex > toIndex");
        }
        if(fromIndex < 0 || toIndex > size){
            throw new IndexOutOfBoundsException("fromIndex < 0 or toIndex > size");
        }
    }
}
