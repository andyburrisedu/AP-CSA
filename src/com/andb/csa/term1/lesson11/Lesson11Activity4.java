package com.andb.csa.term1.lesson11;

import java.util.Scanner;

public class Lesson11Activity4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(new String[]{"Even", "Odd"}[input % 2]);

    }
}
