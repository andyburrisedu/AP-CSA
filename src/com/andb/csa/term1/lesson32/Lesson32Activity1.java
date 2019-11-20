package com.andb.csa.term1.lesson32;

public class Lesson32Activity1 {
    public static void main(String[] args) {
        monthName(8);
    }

    public static String[] names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void monthName(int month) {
        System.out.println(names[month - 1]);
    }
}
