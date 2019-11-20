package com.andb.csa.term1.lesson12;

import java.util.Scanner;

public class Lesson12Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input1 = scanner.nextDouble();
        if (0 <= input1 && input1 <= 100) {
            System.out.println("Valid");
        } else {
            System.out.println("Not Valid");
        }
    }
}
