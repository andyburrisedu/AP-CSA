package com.andb.csa.term1.lesson7;

import java.util.Scanner;

public class Lesson7Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Here are the three digits:");
        System.out.println((num / 100) % 10);
        System.out.println((num / 10) % 10);
        System.out.println(num % 10);
    }
}
