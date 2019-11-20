package com.andb.csa.term1.assignments;

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        //Initial name dialog
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome. What is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ". Try your best to crack the code!\n");

        //First phase - takes a number from the console, checks if it is 3 (see below methods),
        //and either prints correct and continues or incorrect and breaks
        System.out.println("PHASE 1\n" + "Enter a number: ");
        int p1 = scanner.nextInt();
        if (checkPhase1(p1)) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Sorry, that was incorrect!\n" + "Better luck next time!");
            return;
        }

        //Second phase - takes a number from the console, checks if it is 1 or between 3 and 100, inclusive (see below methods),
        //and either prints correct and continues or incorrect and breaks
        System.out.println("PHASE 2\n" + "Enter a number: ");
        int p2 = scanner.nextInt();
        if (checkPhase2(p2)) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Sorry, that was incorrect!\n" + "Better luck next time!");
            return;
        }

        //Third phase - takes a number from the console, checks if it is positive and divisible by either 3 or 7 (see below methods),
        //and either prints correct and finishes or incorrect and breaks
        System.out.println("PHASE 3\n" + "Enter a number: ");
        int p3 = scanner.nextInt();
        if (checkPhase3(p3)) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Sorry, that was incorrect!\n" + "Better luck next time!");
            return;
        }
        System.out.println("You have cracked the code!");
    }

    //Methods to check whether inputs are correct
    //Check if input is 3
    private static boolean checkPhase1(int input) {
        return input == 3;
    }

    //Checks if input is 1 or between 3 and 100 inclusive
    private static boolean checkPhase2(int input) {
        return input == 1 || (33 <= input && input <= 100);
    }

    //Checks if input is positive and divisible by either 3 or 7
    private static boolean checkPhase3(int input) {
        return input > 0 && (input % 3 == 0 || input % 7 == 0);
    }
}
