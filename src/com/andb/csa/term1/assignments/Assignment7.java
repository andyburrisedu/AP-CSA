package com.andb.csa.term1.assignments;

import java.util.Scanner;

/**
 * A program to test some arbitrary methods
 *
 * @author Andy Burris
 * @version 13 November 2019
 */
public class Assignment7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Methods Sampler Platter. Please enter a String to duplicate.");
        String toDuplicate = scanner.nextLine();
        System.out.println("The duplicated String is: " + duplicate(toDuplicate));

        System.out.println("Next, please enter a String to check for Edhesive Palindromes.");
        String palindrome = scanner.nextLine();
        String response = isEdhesivePalindrome(palindrome) ? "Nice, you found an Edhesive Palindrome!" : "Too bad, that isn't an Edhesive Palindrome.";
        System.out.println(response);

        System.out.println("Almost done! Please enter a number to scramble.");
        double toScramble = scanner.nextDouble();
        System.out.println("The scrambled number is: " + numberScramble(toScramble));
    }

    /**
     * A method to duplicate the characters of a string based on how many letters the total string has. Duplicates by n if odd, n * 2 if even where n = str.length
     *
     * @param str String to duplicate
     * @return Duplicated string
     */
    public static String duplicate(String str) {
        int duplicateAmount = str.length();
        if (str.length() % 2 == 0) {
            duplicateAmount *= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            for (int i = 0; i < duplicateAmount; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Method to check if input string is an "Edhesive Palindrome".
     * An Edhesive Palindrome must meet the following requirements:
     * <p>
     * The String parameter str must read the same backward as forwards. (e.g. "racecar" is a valid Edhesive Palindrome). Case does NOT matter. (e.g. "RaceCar" is still valid)
     * The following characters are equivalent:
     * a ~ 4
     * e ~ 3
     * o ~ 0
     * <p>
     * NOTE: The letters are shown in lower-case, but since the case does NOT matter, both 'a' and 'A' is equivalent to '4'. (e.g. "R4ceCar" is still valid)
     * The String parameter str must be of length greater than 3 and less than 15 (e.g. "R4ceCar" is still valid. But "mom" and "dad" are NOT valid).
     *
     * @param str String to check
     * @return Boolean of whether a valid Edhesive Palindrome - true if valid and false if not
     */
    public static boolean isEdhesivePalindrome(String str) {
        if (str.length() <= 3 || str.length() >= 15) {
            return false;
        }
        str = convertEdhesiveString(str);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method for {@link #isEdhesivePalindrome(String)} that converts the special number characters into letters, and standardized case for comparison
     *
     * @param input Unparsed string
     * @return Parsed string
     */
    private static String convertEdhesiveString(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '4':
                    sb.append('a');
                    continue;
                case '3':
                    sb.append('e');
                    continue;
                case '0':
                    sb.append('o');
                    continue;
            }
            sb.append(c);
        }
        return sb.toString().toLowerCase();
    }

    /**
     * Method that applies a series of operations to a number:
     * i. add 5 to num
     * ii. divide num by 2
     * iii. square root num
     *
     * @param num Input number
     * @return number with operations applied
     */
    private static double numberScramble(double num) {
        if (num < 0) {
            return 0.0;
        }
        return Math.sqrt((num + 5) / 2);
    }
}
