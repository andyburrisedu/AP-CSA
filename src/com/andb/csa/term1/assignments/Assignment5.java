package com.andb.csa.term1.assignments;

import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How long do you want the array?");
        int length = scanner.nextInt();
        if (length < 1) {
            System.out.println("Not a valid length!");
            return;
        }

        //create an array with the specified length and request that number of numbers to populate it
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number");
            array[i] = scanner.nextDouble();
        }

        System.out.println("Your array is " + arrayToString(array));
        System.out.println("The average is " + arrayAverage(array));
        System.out.println("The range is " + arrayRange(array));
        System.out.println("The array is " + arrayIsSorted(array));
    }

    /**
     * Alternative to {@link java.util.Arrays#toString(double[])} using "{" and "}" as surrounding characters
     *
     * @param array Array to parse
     * @return String representation of array
     */
    private static String arrayToString(double[] array) {
        return arrayToString(array, "{", "}", ", ");
    }

    /**
     * Alternative to {@link java.util.Arrays#toString(double[])} with options for initial, end, and separator characters
     *
     * @param array       Array to parse
     * @param initialChar Character (or string of chars) for start of String
     * @param endChar     Character (or string of chars) for end of String
     * @param separator   Character (or string of chars) to separate values in String
     * @return String representation of array
     */
    private static String arrayToString(double[] array, String initialChar, String endChar, String separator) {
        StringBuilder sb = new StringBuilder(initialChar);
        for (int i = 0; i < array.length; i++) {
            sb.append(Double.toString(array[i]));
            if (i < array.length - 1) {
                sb.append(separator);
            }
        }
        sb.append(endChar);
        return sb.toString();
    }

    /**
     * Method to calculate average of array of doubles
     *
     * @param array Array to calculate
     * @return Average of array as double
     */
    private static double arrayAverage(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    /**
     * Method to calculate range of array of doubles
     *
     * @param array Array to calculate
     * @return Range of array as double
     */
    private static double arrayRange(double[] array) {
        double currentMin = array[0];
        double currentMax = array[0];
        for (double value : array) {
            currentMin = Math.min(currentMin, value);
            currentMax = Math.max(currentMax, value);
        }
        return currentMax - currentMin;
    }

    /**
     * Method to determine whether an array is sorted in either ascending or descending order
     *
     * @param array Array to determine sort from
     * @return String of which sort type - either "sorted in increasing order", "sorted in decreasing order", or "unsorted"
     */
    private static String arrayIsSorted(double[] array) {
        boolean sortedAscending = true;
        boolean sortedDescending = true;
        double lastValue = array[0];
        for (double value : array) {
            if (value > lastValue) {
                sortedDescending = false;
            }
            if (value < lastValue) {
                sortedAscending = false;
            }
            lastValue = value;
        }
        if (sortedAscending) {
            return "sorted in increasing order";
        } else if (sortedDescending) {
            return "sorted in decreasing order";
        } else {
            return "unsorted";
        }
    }
}
