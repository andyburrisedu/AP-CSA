package com.andb.csa.notes.graphics;

import com.andb.csa.library.StdDraw;

import java.awt.*;

public class StdDrawTest {
    public static void main(String[] args) {

        StdDraw.setPenColor(Color.BLUE);

        int NUM_CIRCLES = 100;
        for (int i = 1; i < NUM_CIRCLES; i++) {
            StdDraw.circle(0.5, 0.5, i * .5 / NUM_CIRCLES);
        }
    }
}
