package com.andb.csa.term2.labs.steganography;

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
}
