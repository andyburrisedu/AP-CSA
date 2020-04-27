package com.andb.csa.term2.activities.activityg;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] a1, int[] a2) {
        int i1 = 0;
        int i2 = 0;
        int[] out = new int[a1.length + a2.length];
        while (i1 < a1.length || i2 < a2.length) {

            if (i1 >= a1.length) {
                out[i1 + i2] = a2[i2];
                i2++;
            } else if (i2 >= a2.length) {
                out[i1 + i2] = a1[i1];
                i1++;
            } else {
                out[i1 + i2] = Math.min(a1[i1], a2[i2]);
                if (a1[i1] < a2[i2]) {
                    i1++;
                } else {
                    i2++;
                }
            }


        }
        return out;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9, 10, 14};
        int[] array2 = {0, 2, 4, 6, 8, 11};
        System.out.println(Arrays.toString(merge(array1, array2)));
    }
}
