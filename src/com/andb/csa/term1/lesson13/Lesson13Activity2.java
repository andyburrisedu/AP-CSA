package com.andb.csa.term1.lesson13;

import java.util.Scanner;

public class Lesson13Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        if (input1 >= 60) {
            System.out.println("passing");
        } else {
            System.out.println("failing");
        }
    }
}
