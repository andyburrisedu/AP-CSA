package com.andb.csa.term1.lesson14;

import java.util.Scanner;

public class Lesson14Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        if (!(5 <= input1 && input1 <= 76)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
