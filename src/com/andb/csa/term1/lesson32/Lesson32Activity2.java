package com.andb.csa.term1.lesson32;

public class Lesson32Activity2 {
    public static void main(String[] args) {
        monthDays(2);
    }

    public static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void monthDays(int month) {
        System.out.println(days[month - 1]);
    }
}
