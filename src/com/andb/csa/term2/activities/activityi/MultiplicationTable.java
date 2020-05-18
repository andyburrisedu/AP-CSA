package com.andb.csa.term2.activities.activityi;

import java.util.Arrays;

public class MultiplicationTable {
    public static int[][] multTable(int rows, int columns) {
        int[][] table = new int[rows][columns];
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = row * col;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        String out = Arrays.deepToString(multTable(6, 4)).replace("], ", "]\n");
        System.out.println(out);
    }
}
