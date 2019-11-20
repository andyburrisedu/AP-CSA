package com.andb.csa.term1.assignments;

import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input message to be shortened
        System.out.println("Type the message to be shortened: ");
        String toShorten = scanner.nextLine();
        System.out.println("\n");

        //Check if message is less than 10 characters, return incorrect message and break
        if (toShorten.length() < 10) {
            System.out.println("This doesn't need shortening!");
            return;
        }

        String toShortenLowercase = toShorten.toLowerCase(); //lowercase to only check against lowercase chars
        StringBuilder shortened = new StringBuilder(); //use StringBuilder to concatenate in loops
        int vowelsRemoved = 0; //variable to count how many vowels were removed
        int repeatedRemoved = 0; //variable to count how many repeated letters were removed

        for (int i = 0; i < toShortenLowercase.length(); i++) {
            char current = toShortenLowercase.charAt(i);
            //first character stays if it is a vowel (since it is the start of a word), can't be repeated
            if (i == 0) {
                shortened.append(current);
                continue;
            }
            //now know that i>0, we can find last char w/o IndexOutOfBoundsException
            char last = toShortenLowercase.charAt(i - 1);

            //remove vowel unless start of word
            if (isVowel(current) && last != ' ') {
                vowelsRemoved++;
                continue;
            }

            //remove char if it is the same as the previous
            if (current == last) {
                repeatedRemoved++;
                continue;
            }
            shortened.append(current);//append char to StringBuilder
        }
        System.out.println("Shortened message: " + shortened.toString());
        System.out.println("Repeated letters removed: " + repeatedRemoved);
        System.out.println("Vowels removed: " + vowelsRemoved);
        System.out.println("Total characters saved: " + (toShortenLowercase.length() - shortened.toString().length()));
    }

    //method to check if lowercase char is a vowel
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
