package com.andb.csa.term1.assignments;

import java.util.Scanner;

/**
 * A program to merge two arrays of integers
 *
 * @author Andy Burris
 * @version 30 Oct 2019
 */
public class Assignment6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraysSize = 0;
        while (arraysSize < 10) {
            System.out.println("Enter an array length (must be 10 or greater):");
            arraysSize = scanner.nextInt();
        }

        int[] array1 = new int[arraysSize];
        int[] array2 = new int[arraysSize];

        for (int i = 0; i < arraysSize; i++) {
            array1[i] = random(1, 101);
            array2[i] = random(1, 101);
        }

        System.out.println("First Array: " + arrayToString(array1, "", "", " "));
        System.out.println("Second Array: " + arrayToString(array2, "", "", " "));

        int[] mergedArray = mergeArraysAlternating(array1, array2);

        System.out.println("Merged Array: " + arrayToString(mergedArray, "", "", " "));

    }

    /**
     * Merges two int arrays in alternating order (1, 2, 1, 2, 1, 2...), removing duplicates
     *
     * @param array1 First int array to merge
     * @param array2 Second int array to merge
     * @return Merged int array
     */
    private static int[] mergeArraysAlternating(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];
        int mergedIndex = 0;
        for (int i = 0; i < array1.length; i++) {
            int element1 = array1[i];
            int element2 = array2[i];
            if (!contains(merged, element1)) {
                merged[mergedIndex] = element1;
                mergedIndex++;
            }
            if (!contains(merged, element2)) {
                merged[mergedIndex] = element2;
                mergedIndex++;
            }
        }
        return merged;
    }

    /**
     * Checks if a given value is within an array
     *
     * @param array   Array of ints to check value against
     * @param element Value to check for in array
     * @return Boolean - found or not found
     */
    private static boolean contains(int[] array, int element) {
        boolean found = false;
        for (int i : array) {
            if (i == element) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Alternative to {@link java.util.Arrays#toString(int[])} with options for initial, end, and separator characters that trims empty (zero) values at end
     *
     * @param array       Array to parse
     * @param initialChar Character (or string of chars) for start of String
     * @param endChar     Character (or string of chars) for end of String
     * @param separator   Character (or string of chars) to separate values in String
     * @return String representation of array
     */
    private static String arrayToString(int[] array, String initialChar, String endChar, String separator) {
        StringBuilder sb = new StringBuilder(initialChar);
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (element == 0) {
                continue;
            }
            sb.append(element);
            if (i < array.length - 1) {
                sb.append(separator);
            }
        }
        sb.append(endChar);
        return sb.toString();
    }

    /**
     * Calculates random integer within a range
     *
     * @param baseInclusive    Bottom of random range (possible to be a returned value)
     * @param ceilingExclusive Top of random range (can't be a returned value)
     * @return Random integer in range
     */
    private static int random(int baseInclusive, int ceilingExclusive) {
        int range = ceilingExclusive - baseInclusive;
        return (int) (Math.random() * range + baseInclusive);
    }
}
