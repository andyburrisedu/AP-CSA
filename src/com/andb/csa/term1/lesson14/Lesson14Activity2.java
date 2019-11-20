package com.andb.csa.term1.lesson14;

import java.util.Scanner;

public class Lesson14Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        if (isNegative(input1) || isNegative(input2)) {
            System.out.println("One or both are negative.");
        } else {
            System.out.println("Both are positive or zero.");
        }
    }

    private static boolean isNegative(int in) {
        return in < 0;
    }
}
