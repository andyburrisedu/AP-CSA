package com.andb.csa.term1.lesson3;

import java.util.Scanner;

public class Lesson3Activity2 {
    public static void main(String[] args) {
        System.out.println("Type three names:");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        String name3 = scanner.nextLine();
        System.out.println(name3 + " " + name2 + " " + name1);
    }
}
