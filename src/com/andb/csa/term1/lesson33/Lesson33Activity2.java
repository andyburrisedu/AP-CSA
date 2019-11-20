package com.andb.csa.term1.lesson33;

import java.util.Arrays;

public class Lesson33Activity2 {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        System.out.println(Arrays.toString(arr));
        randomize(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void randomize(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90 + 10);
        }
    }
}
