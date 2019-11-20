package com.andb.csa.term1.lesson3;

import java.util.Scanner;

public class Lesson3Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi there. What is your name?");
        String name = scanner.nextLine();
        System.out.println("What adjective describes you?");
        String adjective = scanner.nextLine();
        System.out.println("My name is " + name + ". I am " + adjective + ".");
    }
}
