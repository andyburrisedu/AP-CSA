package com.andb.csa.term1.lesson13;

import java.util.Scanner;

public class Lesson13Activity5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1 = (int) (Math.random() * 12) + 1;
        int m2 = (int) (Math.random() * 12) + 1;
        int mult = m1 * m2;
        System.out.println(m1);
        System.out.println(m2);
        int input1 = scanner.nextInt();
        if (input1 == mult) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong");
        }
    }
}
