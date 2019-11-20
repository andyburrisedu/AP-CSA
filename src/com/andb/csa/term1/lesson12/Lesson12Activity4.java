package com.andb.csa.term1.lesson12;

import java.util.Scanner;

public class Lesson12Activity4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input1 = scanner.nextDouble();
        if (!(99 <= input1 && input1 <= 102)) {
            System.out.println("WARNING");
        }
    }
}
