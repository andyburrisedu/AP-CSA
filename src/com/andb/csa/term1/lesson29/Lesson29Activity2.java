package com.andb.csa.term1.lesson29;

public class Lesson29Activity2 {
    public static String[] list = {};

    public static void main(String[] args) {
        for (String word : list) {
            System.out.println(reverse(word));
        }
    }

    public static String reverse(String original) {
        return new StringBuilder(original).reverse().toString();
    }
}
