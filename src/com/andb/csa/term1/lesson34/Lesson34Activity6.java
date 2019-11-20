package com.andb.csa.term1.lesson34;

public class Lesson34Activity6 {
    public static boolean allPositive(int[] array) {
        for (int i : array) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
