package com.andb.csa.term1.lesson17;

import java.util.Scanner;

public class Lesson17Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 1; //buffer for eventual -1
        int count = -1; //buffer for eventual extra w/ -1
        int n = 0;
        while (n != -1) {
            n = scanner.nextInt();
            count++;
            sum += n;
        }
        System.out.println("The average is: " + (sum / ((double) count)));
    }
}
