package com.andb.csa.term1.lesson34;

public class Lesson34Activity5 {
    public static int sumEven(int[] array) {
        int sum = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
