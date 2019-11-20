package com.andb.csa.term1.lesson29;

public class Lesson29Activity1 {
    public static String[] list = {};

    public static void main(String[] args) {
        String longest = list[0];
        for (String word : list) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println(longest);
    }
}
