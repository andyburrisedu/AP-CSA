package com.andb.csa.term1.lesson34;

public class Lesson34Activity3 {
    public static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
