package com.andb.csa.term1.lesson5;

import java.util.Scanner;

public class Lesson5Activity4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = scanner.nextDouble();
        System.out.println("Change from $20: $" + (20 - price));
    }
}
