package com.andb.csa.term1.lesson34;

public class Lesson34Activity2 {
    public static double average(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum / (array.length * 1.0);
    }
}
