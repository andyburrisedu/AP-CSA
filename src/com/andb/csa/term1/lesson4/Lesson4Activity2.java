package com.andb.csa.term1.lesson4;

import java.util.Scanner;

public class Lesson4Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi there. What is your name?");
        String name = scanner.nextLine();
        System.out.println("Hi " + name + ". How old are you?");
        int age = scanner.nextInt();
        System.out.println(name + ", you will be 100 in " + (100 - age) + " years.");
    }
}
