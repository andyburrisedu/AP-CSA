package com.andb.csa.term1.lesson33;

import java.util.Arrays;

public class Lesson33Activity3 {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        System.out.println(Arrays.toString(arr));
        printit(arr);
    }

    public static void printit(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
