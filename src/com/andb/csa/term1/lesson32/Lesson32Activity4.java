package com.andb.csa.term1.lesson32;

public class Lesson32Activity4 {

    private static int SECONDS_PER_MIN = 60;
    private static int SECONDS_PER_HOUR = SECONDS_PER_MIN * 60;

    public static void main(String[] args) {
        realTime(6342);
    }

    public static void realTime(int seconds) {
        int hours = seconds / SECONDS_PER_HOUR;
        seconds = seconds % SECONDS_PER_HOUR;
        int minutes = seconds / SECONDS_PER_MIN;
        seconds = seconds % SECONDS_PER_MIN;
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + seconds);
    }
}
