package com.andb.csa.term2.lesson17;

public class Lesson17Activity {
    public static void main(String[] args) {
        int[] sortedTest = {1, 2, 3, 4, 5, 7, 8, 9, 123};
        int[] unsortedTest = {1, 2, 3, 4, 2, 2, 5, 239, 4};
        assertEquals(isSorted(sortedTest), true);
        assertEquals(isSorted(unsortedTest), false);
        assertEquals(binarySearch(sortedTest, 2), 1);
        assertEquals(binarySearch(sortedTest, 123), 8);
        assertEquals(binarySearch(sortedTest, 9), 7);
        assertEquals(binarySearch(sortedTest, 8), 6);
        assertEquals(binarySearch(sortedTest, 7), 5);
        assertEquals(binarySearch(sortedTest, 6), -1);
        System.out.println(binarySearch(sortedTest, 3));
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] array, int searchTerm) {
        int left = 0;
        int right = array.length - 1;
        int midpoint = (right - left) / 2;

        while (left <= right) {
            System.out.println("left = " + left + ", right = " + right + ", midpoint = " + midpoint);
            int value = array[midpoint];
            System.out.println("value = " + value + "\n");

            if (value == searchTerm) {
                return midpoint;
            } else if (value > searchTerm) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
            midpoint = (right - left) / 2 + left;
        }

        System.out.println("left = " + left + ", right = " + right + ", midpoint = " + midpoint);
        return -1;
    }

    private static <T> void assertEquals(T p1, T p2) {
        assertEquals(p1, p2, p1.toString() + " != " + p2.toString());
    }

    private static <T> void assertEquals(T p1, T p2, String message) {
        if (p1 != p2) {
            throw new AssertionError(message);
        }
    }
}
