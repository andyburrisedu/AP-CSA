package com.andb.csa.term1.lesson12;

import java.util.Scanner;

public class Lesson12Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input1 = scanner.nextDouble();
        double input2 = scanner.nextDouble();
        double max = Math.max(input1, input2);
        System.out.println("Largest is: " + max);
    }
}
