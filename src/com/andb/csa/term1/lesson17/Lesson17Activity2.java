package com.andb.csa.term1.lesson17;

import java.util.Scanner;

public class Lesson17Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        for (int i = i1; i <= i2; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
