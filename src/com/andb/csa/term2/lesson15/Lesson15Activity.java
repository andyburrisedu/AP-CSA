package com.andb.csa.term2.lesson15;

public class Lesson15Activity {
    public static void main(String[] args) {
        String[] list = {"against", "forms", "belief", "government", "democratic", "movement", "understanding"};
        sortAndPrint(list);
    }

    public static void sortAndPrint(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int nextMin = findMinPos(list, i);
            swap(list, i, nextMin);
        }
        System.out.println(arrayToString(list, "", "", " "));
    }

    public static int findMinPos(String[] array, int startingPosInclusive) {
        int minPos = startingPosInclusive;
        for (int i = startingPosInclusive; i < array.length; i++) {
            if (array[i].compareTo(array[minPos]) < 0) {
                minPos = i;
            }
        }
        return minPos;
    }

    public static void swap(String[] array, int pos1, int pos2) {
        String temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    /**
     * Alternative to {@link java.util.Arrays#toString(Object[])} with options for initial, end, and separator characters
     *
     * @param array       Array to parse
     * @param initialChar Character (or string of chars) for start of String
     * @param endChar     Character (or string of chars) for end of String
     * @param separator   Character (or string of chars) to separate values in String
     * @return String representation of array
     */
    private static String arrayToString(Object[] array, String initialChar, String endChar, String separator) {
        StringBuilder sb = new StringBuilder(initialChar);
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i].toString());
            if (i < array.length - 1) {
                sb.append(separator);
            }
        }
        sb.append(endChar);
        return sb.toString();
    }
}
