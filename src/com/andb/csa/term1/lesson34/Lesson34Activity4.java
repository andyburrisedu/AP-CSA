package com.andb.csa.term1.lesson34;

public class Lesson34Activity4 {
    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
