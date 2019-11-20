package com.andb.csa.term2.lesson1;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson1Activity1 {
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

        System.out.println(wordList.size());
        System.out.println(wordList);
        if (wordList.size() > 2) {
            wordList.remove(wordList.size() - 1);
            wordList.remove(0);
        }
        System.out.println(wordList);
    }
}
