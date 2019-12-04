package com.andb.csa.library;

import java.awt.*;

public class Utils {
    public static Color randomColor() {
        int r = random(0, 255);
        int g = random(0, 255);
        int b = random(0, 255);

        return new Color(r, g, b);
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
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
