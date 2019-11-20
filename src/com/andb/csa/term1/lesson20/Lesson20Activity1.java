package com.andb.csa.term1.lesson20;

import java.util.Scanner;

public class Lesson20Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double farthestNorth = -90.0;
        double farthestSouth = 90.0;
        double farthestEast = -180.0;
        double farthestWest = 180.0;

        double breakFlag = 1;
        while (breakFlag == 1) {
            System.out.println("Please enter the latitude:");
            double newLat = scanner.nextDouble();
            System.out.println("Please enter the longitude:");
            double newLong = scanner.nextDouble();

            if (!inRange(-90, newLat, 90) || !inRange(-180, newLong, 180)) {
                System.out.println("Incorrect Latitude or Longitude");
                continue;
            }

            System.out.println("Would you like to enter another location?");
            breakFlag = scanner.nextDouble();

            if (newLat > farthestNorth) {
                farthestNorth = newLat;
            }
            if (newLat < farthestSouth) {
                farthestSouth = newLat;
            }
            if (newLong > farthestEast) {
                farthestEast = newLong;
            }
            if (newLong < farthestWest) {
                farthestWest = newLong;
            }
        }

        System.out.println("Farthest North: " + farthestNorth);
        System.out.println("Farthest South: " + farthestSouth);
        System.out.println("Farthest East: " + farthestEast);
        System.out.println("Farthest West: " + farthestWest);
    }

    public static boolean inRange(int min, double num, int max) {
        return inRange(min, num, max, true);
    }

    public static boolean inRange(int min, double num, int max, boolean inclusive) {
        if (inclusive) {
            return min <= num && num <= max;
        } else {
            return min < num && num < max;
        }
    }
}

