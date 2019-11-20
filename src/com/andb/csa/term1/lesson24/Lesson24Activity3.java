package com.andb.csa.term1.lesson24;

import java.util.Scanner;

public class Lesson24Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (!(0 <= input && input <= 100)) {
            System.out.println("error");
            return;
        }

        for (int i = input; i <= 100; i++) {
            System.out.print(i + " ");
            if (i % 20 == ((input % 20) - 1)) {
                System.out.print("\n");
            }
        }
    }
}
