package com.andb.csa.term1.lesson33;

import java.util.Arrays;

public class Lesson33Activity1 {
    public static void main(String[] args) {
        String[] arr = {"lower", "mIxEd", "UPPER"};
        System.out.println(Arrays.toString(arr));
        upper(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void upper(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].toUpperCase();
        }
    }
}
