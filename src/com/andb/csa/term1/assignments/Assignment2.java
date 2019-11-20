package com.andb.csa.term1.assignments;

import java.util.Scanner;

public class Assignment2 {
    //Seconds constants for calculation clarity
    private static int SECONDS_PER_MIN = 60;
    private static int SECONDS_PER_HOUR = SECONDS_PER_MIN * 60;
    private static int SECONDS_PER_DAY = SECONDS_PER_HOUR * 24;
    private static int SECONDS_PER_MONTH = SECONDS_PER_DAY * 30;
    private static int SECONDS_PER_YEAR = SECONDS_PER_MONTH * 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seconds Since Unix Epoch:");
        int sinceEpoch = scanner.nextInt();

        //For each unit, find the amount by dividing what is left in sinceEpoch by the seconds constant for the unit,
        //and find the remaining seconds for sinceEpoch by subtracting the integer-floored unit multiplied by the seconds constant
        int year = sinceEpoch / SECONDS_PER_YEAR;
        sinceEpoch -= year * SECONDS_PER_YEAR;

        int month = sinceEpoch / SECONDS_PER_MONTH;
        sinceEpoch -= month * SECONDS_PER_MONTH;

        int day = sinceEpoch / SECONDS_PER_DAY;
        sinceEpoch -= day * SECONDS_PER_DAY;

        int hour = sinceEpoch / SECONDS_PER_HOUR;
        sinceEpoch -= hour * SECONDS_PER_HOUR;

        int minute = sinceEpoch / SECONDS_PER_MIN;
        sinceEpoch -= minute * SECONDS_PER_MIN;

        int second = sinceEpoch;

        System.out.println("Year: " + (year + 1970));
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        System.out.println("Hour: " + hour);
        System.out.println("Min: " + minute);
        System.out.println("Sec: " + second);
    }
}
