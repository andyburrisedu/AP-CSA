package com.andb.csa.term2.lesson2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson2Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();

        System.out.println("Please enter words, enter STOP to stop the loop.");
        boolean flag = false;
        while (!flag) {
            String newValue = scanner.nextLine();
            if (!newValue.equals("STOP")) {
                wordList.add(newValue);
            } else {
                flag = true;
            }
        }

        for (String word : wordList) {
            if (word.contains("a")) {
                System.out.println(word);
            }
        }

    }
}
