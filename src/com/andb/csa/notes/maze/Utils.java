package com.andb.csa.notes.maze;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    public static boolean between(int number, int minInclusive, int maxExclusive) {
        return minInclusive <= number && number < maxExclusive;
    }

    /**
     * Maps a room id to a color to display in graphics
     *
     * @param id between 0 and Integer.MAX_VALUE
     * @return int between 0 and 16777215, the highest integer that represents a 0-255 rgb value
     */
    public static int colorFromID(int id) {
        return mapRange(id, 0, Integer.MAX_VALUE, 0, 16777215);
    }

    public static int mapRange(int number, int oldMin, int oldMax, int newMin, int newMax) {
        double percentThrough = ((double) number - oldMin) / (oldMax - oldMin);
        double mapped = newMin + (percentThrough * (newMax - newMin));
        return (int) mapped;
    }


    public static <T> ArrayList<T> arrayListOf(T... elements) {
        return new ArrayList<T>(Arrays.asList(elements));
    }
}
