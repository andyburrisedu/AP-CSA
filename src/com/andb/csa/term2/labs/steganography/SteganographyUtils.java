package com.andb.csa.term2.labs.steganography;

import java.awt.*;

public class SteganographyUtils {
    static int clearLastTwoBits(int original) {
        return roundDownToMultiple(original, 4);
    }

    static int setLastTwoBits(int original, int setTo) {
        return clearLastTwoBits(original) + setTo;
    }

    static int getFirstTwoBits(int original) {
        return original / 64;
    }

    static int roundDownToMultiple(int original, int multiple) {
        return original - original % multiple;
    }

    static int bringLastTwoBitsToFront(int original) {
        return (getLastTwoBits(original) * 64) + (original / 4);
    }

    static int getLastTwoBits(int original) {
        return original % 4;
    }

    public static void main(String[] args) {
        Color source = new Color(234, 172, 92);
        Color secret = new Color(120, 34, 196);
        Color combined = new Color(
                setLastTwoBits(source.getRed(), getFirstTwoBits(secret.getRed())),
                setLastTwoBits(source.getGreen(), getFirstTwoBits(secret.getGreen())),
                setLastTwoBits(source.getBlue(), getFirstTwoBits(secret.getBlue()))
        );
        System.out.println(combined);
        System.out.println(bringLastTwoBitsToFront(combined.getRed()));
        System.out.println(bringLastTwoBitsToFront(combined.getGreen()));
        System.out.println(bringLastTwoBitsToFront(combined.getBlue()));

    }
}
