package com.andb.csa.term1.lesson35;

public class Lesson35Activity1 {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(randomize(0, 10.0) + " ");
        }
    }

    public static int randomize(int max) {
        return randomize(0, max);
    }

    public static int randomize(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static double randomize(double max) {
        return randomize(0, max);
    }

    public static double randomize(double min, double max) {
        return (double) (Math.random() * (max - min) + min);
    }

}
