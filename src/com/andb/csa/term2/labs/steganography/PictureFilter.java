package com.andb.csa.term2.labs.steganography;

import com.andb.csa.library.Utils;
import com.andb.csa.term2.labs.picture.Picture;
import com.andb.csa.term2.labs.picture.Pixel;

import java.util.ArrayList;

public class PictureFilter {
    private static String FOLDER_PATH = "src/com/andb/csa/term2/labs/picture/images/";

    private Picture picture;
    private ArrayList<Filter> filters = new ArrayList<>();

    public PictureFilter(Picture picture) {
        this.picture = picture;
    }

    public Picture getOriginalPicture() {
        return picture;
    }

    public Picture getFilteredPicture() {
        Picture copy = new Picture(picture);
        filters.forEach(filter -> filter.filter(copy));
        return copy;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public static void main(String[] args) {
        Picture beach = new Picture(FOLDER_PATH + "beach.jpg");
        PictureFilter pictureFilter = new PictureFilter(beach);
        Filter contrastFilter = new Filter() {
            double contrastFactor = 1.5;

            @Override
            void filterPixel(Pixel pixel) {
                int red = applyContrast(pixel.getRed());
                int green = applyContrast(pixel.getGreen());
                int blue = applyContrast(pixel.getBlue());
                pixel.updatePicture(pixel.getAlpha(), red, green, blue);
            }

            int applyContrast(int color) {
                return Utils.coerce((int) (contrastFactor * (color - 128) + 128), 0, 255);
            }
        };

        Filter brightnessFilter = new Filter() {
            int brightnessIncrease = 25;

            @Override
            void filterPixel(Pixel pixel) {
                int red = applyBrightness(pixel.getRed());
                int green = applyBrightness(pixel.getGreen());
                int blue = applyBrightness(pixel.getBlue());
                pixel.updatePicture(pixel.getAlpha(), red, green, blue);
            }

            int applyBrightness(int color) {
                return Utils.coerce(color + brightnessIncrease, 0, 255);
            }
        };

        pictureFilter.addFilter(contrastFilter);
        pictureFilter.addFilter(brightnessFilter);
        beach.explore();
        pictureFilter.getFilteredPicture().explore();
    }
}
