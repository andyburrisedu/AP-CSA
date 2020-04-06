package com.andb.csa.notes.pi;

public class Pi {

    public static void main(String[] args) {
        System.out.println(calculateTo(1000000000));
        //System.out.println(randomCalculate());
    }

    private static double calculateTo(int terms) {
        //int terms = digits
        double currentCalc = 0;
        for (int i = terms - 1; i >= 0; i--) {
            double fraction = 1.0 / (2 * i + 1);
            if (i % 2 == 1) {
                fraction *= -1;
            }
            currentCalc += fraction;
            //System.out.println("currentCalc = " + currentCalc);
        }
        return currentCalc * 4;
    }

    private static double randomCalculate() {
        int randomPoints = Integer.MAX_VALUE;
        int inCircle = 0;
        for (int i = 0; i < randomPoints; i++) {
            double x = Math.random();
            double y = Math.random();
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                inCircle++;
            }
        }
        return ((double) inCircle / randomPoints) * 4;
    }
}
