package com.andb.csa.term1.lesson30;

import java.util.Scanner;

public class Lesson30HalfActivity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number in base 8:");
        int octalInput = scanner.nextInt();
        if (!checkOctal(octalInput)) {
            System.out.println("ERROR: Incorrect Octal Format");
        } else {
            System.out.println(toDecimal(octalInput));
        }
    }

    private static boolean checkOctal(int possible) {
        if (possible >= 100000000) { //8 digits or less
            return false;
        }
        while (possible > 0) {
            if (possible % 10 > 7) {
                return false;
            } else {
                possible = possible / 10;
            }
        }
        return true;
    }

    private static int toDecimal(int octal) {
        int decimal = 0;
        int place = 1;
        while (octal > 0) {
            int octalDigit = octal % 10;
            decimal += octalDigit * (place);
            octal = octal / 10;
            place *= 8;
        }
        return decimal;
    }
}
