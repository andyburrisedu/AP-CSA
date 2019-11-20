package com.andb.csa.term1.lesson13;

import java.util.Scanner;

public class Lesson13Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        if (input1 == input2) {
            System.out.println("EQUAL");
        } else {
            System.out.println(Math.max(input1, input2));
        }
    }
}
