package com.andb.csa.term1.lesson12;

import java.util.Scanner;

public class Lesson12Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        int input3 = scanner.nextInt();
        double avg = (input1 + input2 + input3) / 3.0;
        if (avg >= 89.5) {
            System.out.println("ABOVE AVERAGE");
        }
    }
}
