package com.andb.csa.term1.lesson14;

import java.util.Scanner;

public class Lesson14Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int octet1 = scanner.nextInt();
        int octet2 = scanner.nextInt();
        int octet3 = scanner.nextInt();
        int octet4 = scanner.nextInt();
        if (!validOctet(octet1)) {
            System.out.println("Octet 1 is incorrect");
        }
        if (!validOctet(octet2)) {
            System.out.println("Octet 2 is incorrect");
        }
        if (!validOctet(octet3)) {
            System.out.println("Octet 3 is incorrect");
        }
        if (!validOctet(octet4)) {
            System.out.println("Octet 4 is incorrect");
        }
        if (validOctet(octet1) && validOctet(octet2) && validOctet(octet3) && validOctet(octet4)) {
            System.out.println("IP Address: " + octet1 + "." + octet2 + "." + octet3 + "." + octet4);
        }
    }

    private static boolean validOctet(int in) {
        return 0 <= in && in <= 255;
    }
}
