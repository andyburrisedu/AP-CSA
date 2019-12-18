package com.andb.csa.library;

import java.awt.*;

public class Utils {
    public static Color randomColor() {
        int r = random(0, 255);
        int g = random(0, 255);
        int b = random(0, 255);

        return new Color(r, g, b);
    }

    /**
     * Calculates random integer within a range
     *
     * @param baseInclusive    Bottom of random range (possible to be a returned value)
     * @param ceilingExclusive Top of random range (can't be a returned value)
     * @return Random integer in range
     */
    public static int random(int baseInclusive, int ceilingExclusive) {
        int range = ceilingExclusive - baseInclusive;
        return (int) (Math.random() * range + baseInclusive);
    }

    /**
     * Calculates random double within a range
     *
     * @param baseInclusive    Bottom of random range (possible to be a returned value)
     * @param ceilingExclusive Top of random range (can't be a returned value)
     * @return Random double in range
     */
    public static double random(double baseInclusive, double ceilingExclusive) {
        double range = ceilingExclusive - baseInclusive;
        return (Math.random() * range + baseInclusive);
    }

    public static int coerce(int value, int minInclusive, int maxInclusive) {
        if (value > maxInclusive) {
            return maxInclusive;
        }
        if (value < minInclusive) {
            return minInclusive;
        }
        return value;
    }
}
