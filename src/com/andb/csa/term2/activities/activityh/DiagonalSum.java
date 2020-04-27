package com.andb.csa.term2.activities.activityh;

public class DiagonalSum {

    static int diagSum(int[][] array) {
        int sum = 0;
        int min = Math.min(array.length, array[0].length);
        for (int i = 0; i < min; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {2, 4, 5, 8},
                {11, 1, 6, 5},
                {3, 4, 5, 2}
        };
        System.out.println(diagSum(array));
    }
}
