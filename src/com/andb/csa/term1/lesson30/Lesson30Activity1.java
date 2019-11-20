package com.andb.csa.term1.lesson30;

public class Lesson30Activity1 {
    public static String[] list = {};

    public static void main(String[] args) {
        for (int i = 0; i < list.length; i++) {
            String word = list[i];
            list[i] = removeSpaces(word);
        }
    }

    private static String removeSpaces(String original) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
