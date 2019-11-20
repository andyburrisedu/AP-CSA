package com.andb.csa.term1.lesson13;

import java.util.Scanner;

public class Lesson13Activity4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        switch (input1) {
            case 0:
                System.out.println("F");
                break;
            case 1:
                System.out.println("D");
                break;
            case 2:
                System.out.println("C");
                break;
            case 3:
                System.out.println("B");
                break;
            case 4:
                System.out.println("A");
                break;
        }
    }
}
