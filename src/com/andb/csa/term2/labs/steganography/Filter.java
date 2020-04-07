package com.andb.csa.term2.labs.steganography;

import com.andb.csa.term2.labs.picture.Picture;
import com.andb.csa.term2.labs.picture.Pixel;

abstract class Filter {
    void filter(Picture source) {
        Pixel[][] pixels = source.getPixels2D();
        for (int y = 0; y < pixels.length; y++) {
            Pixel[] row = pixels[y];
            for (int x = 0; x < row.length; x++) {
                filterPixel(pixels[y][x]);
            }
        }
    }

    abstract void filterPixel(Pixel pixel);

}