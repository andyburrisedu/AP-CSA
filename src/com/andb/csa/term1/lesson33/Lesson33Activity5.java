package com.andb.csa.term1.lesson33;

import java.util.Arrays;

public class Lesson33Activity5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        insertValue(arr, 100, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertValue(int[] array, int value, int position) {
        for (int i = array.length - 1; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = value;
    }
}
