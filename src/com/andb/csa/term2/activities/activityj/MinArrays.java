package com.andb.csa.term2.activities.activityj;

import java.util.Arrays;

public class MinArrays {
    public static int minValue(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int[] row : mat) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    public static int[] minRow(int[][] mat) {
        int[] rowSums = new int[mat.length];
        for (int row = 0; row < mat.length; row++) {
            rowSums[row] = Arrays.stream(mat[row]).sum();
        }
        int minRowIndex = 0;
        for (int i = 0; i < rowSums.length; i++) {
            if (rowSums[i] < rowSums[minRowIndex]) {
                minRowIndex = i;
            }
        }
        return mat[minRowIndex];
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {5, 8, 2},
                {3, 2, 7},
                {6, 4, 2},
                {7, 7, 3}
        };

        System.out.println(minValue(array));
        System.out.println(Arrays.toString(minRow(array)));
    }


}
