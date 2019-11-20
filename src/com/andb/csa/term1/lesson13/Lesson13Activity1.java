package com.andb.csa.term1.lesson13;

import java.util.Scanner;

public class Lesson13Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input1 = scanner.nextDouble();
        if (input1 >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }
}
