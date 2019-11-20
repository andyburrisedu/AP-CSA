package com.andb.csa.term1.lesson3;

import java.util.Scanner;

public class Lesson3Activity1 {
    public static void main(String[] args) {
        System.out.println("What's your name?");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Hi " + name + ", nice to see you.");
    }
}
