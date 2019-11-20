package com.andb.csa.term1.lesson22;

import java.util.Scanner;

public class Lesson22Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println(c);
        }
    }
}
