package com.andb.csa.term2.labs.steganography;

import com.andb.csa.term2.labs.picture.Picture;
import com.andb.csa.term2.labs.picture.Pixel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Steganography {

    private static String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String FOLDER_PATH = "src/com/andb/csa/term2/labs/picture/images/";

    private static Picture beach = new Picture(FOLDER_PATH + "beach.jpg");
    private static Picture motorcycle = new Picture(FOLDER_PATH + "blueMotorcycle.jpg");
    private static Picture robot = new Picture(FOLDER_PATH + "robot.jpg");
    private static Picture flower1 = new Picture(FOLDER_PATH + "flower1.jpg");

    public static void main(String[] args) {
        activityFour();
    }

    private static void activityOne() {
        beach.explore();
        Picture clearLow = testClearLow(beach);
        clearLow.explore();

        Picture setLow = testSetLow(beach, Color.PINK);
        setLow.explore();
        Picture revealColor = revealPicture(setLow);
        revealColor.explore();
    }

    private static void activityTwo() {
        System.out.println(canHide(beach, motorcycle));
        Picture hidden = hidePicture(beach, motorcycle);
        hidden.explore();
        Picture revealed = revealPicture(hidden);
        revealed.explore();
    }

    private static void activityThree() {
        Picture hiddenRobot = hidePicture(beach, robot, 65, 208);
        Picture hiddenRobotAndFlower = hidePicture(hiddenRobot, flower1, 280, 110);
        hiddenRobotAndFlower.explore();

        Picture unhidden = revealPicture(hiddenRobotAndFlower);
        unhidden.explore();
    }

    private static void activityFour() {
        Picture beachCopy = new Picture(beach);
        beachCopy.explore();
        hideText(beachCopy, "Hello world");
        beachCopy.explore();
        System.out.println(revealText(beachCopy));
    }

    private static Picture testClearLow(Picture picture) {
        Picture copy = new Picture(picture);
        Arrays.stream(copy.getPixels()).forEach(Steganography::clearLow);
        return copy;
    }

    /**
     * Clear the lower (rightmost) two bits in a pixel.
     */
    private static void clearLow(Pixel p) {
        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();
        int alpha = p.getAlpha();
        p.updatePicture(alpha, SteganographyUtils.clearLastTwoBits(red), SteganographyUtils.clearLastTwoBits(green), SteganographyUtils.clearLastTwoBits(blue));
    }

    private static Picture testSetLow(Picture picture, Color color) {
        Picture copy = new Picture(picture);
        Arrays.stream(copy.getPixels()).forEach(p -> setLow(p, color));
        return copy;
    }

    /**
     * Set the lower 2 bits in a pixel to the highest 2 bits in c
     */
    private static void setLow(Pixel p, Color c) {
        int newRed = SteganographyUtils.getFirstTwoBits(c.getRed());
        int newGreen = SteganographyUtils.getFirstTwoBits(c.getGreen());
        int newBlue = SteganographyUtils.getFirstTwoBits(c.getBlue());
        clearLow(p);
        p.updatePicture(p.getAlpha(), p.getRed() + newRed, p.getGreen() + newGreen, p.getBlue() + newBlue);
    }

    /**
     * Sets the highest two bits of each pixel’s colors * to the lowest two bits of each pixel’s colors
     */
    private static Picture revealPicture(Picture hidden) {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                Color col = source[r][c].getColor();
                pixels[r][c].updatePicture(
                        col.getAlpha(),
                        SteganographyUtils.bringLastTwoBitsToFront(col.getRed()),
                        SteganographyUtils.bringLastTwoBitsToFront(col.getGreen()),
                        SteganographyUtils.bringLastTwoBitsToFront(col.getBlue())
                );
            }
        }
        return copy;
    }

    /**
     * Determines whether secret can be hidden in source, which is
     * true if source and secret are the same dimensions.
     *
     * @return true if secret can be hidden in source, false otherwise.
     */
    public static boolean canHide(Picture source, Picture secret) {
        return source.getWidth() >= secret.getWidth() && source.getHeight() >= secret.getHeight();
    }

    /**
     * Creates a new Picture with data from secret hidden in data from source * @param source is not null
     *
     * @param secret is not null
     * @return combined Picture with secret hidden in source
     * precondition: source is same width and height as secret
     */
    private static Picture hidePicture(Picture source, Picture secret) {
        return hidePicture(source, secret, 0, 0);
    }

    private static Picture hidePicture(Picture source, Picture secret, int startRow, int startColumn) {
        Picture copy = new Picture(source);
        Pixel[][] sourceMatrix = copy.getPixels2D();
        Pixel[][] secretMatrix = secret.getPixels2D();
        for (int y = 0; y < secretMatrix.length; y++) {
            Pixel[] row = secretMatrix[y];
            for (int x = 0; x < row.length; x++) {
                Pixel sourcePixel = sourceMatrix[y + startRow][x + startColumn];
                setLow(sourcePixel, secretMatrix[y][x].getColor());
            }
        }
        return copy;
    }

    /**
     * Hide a string (must be only capital letters and spaces) in a picture.
     * The string always starts in the upper left corner.
     *
     * @param source picture to hide string in
     * @param s      string to hide
     */
    private static void hideText(Picture source, String s) {
        ArrayList<Integer> encoded = encodeString(s);
        Pixel[] sourceMatrix = source.getPixels();
        for (int i = 0; i < encoded.size(); i++) {
            int toEncode = encoded.get(i);
            int[] bits = getBitPairs(toEncode);
            List<Pixel> pixels = Arrays.asList(sourceMatrix[i * 3], sourceMatrix[i * 3 + 1], sourceMatrix[i * 3 + 2]);
            for (int j = 0; j < pixels.size(); j++) {
                Pixel p = pixels.get(j);
                int encodedBlue = SteganographyUtils.setLastTwoBits(p.getBlue(), bits[j]);
                p.setBlue(encodedBlue);
            }
        }
    }

    /**
     * Returns a string hidden in the picture
     *
     * @param source picture with hidden string
     * @return revealed string
     */

    public static String revealText(Picture source) {
        ArrayList<Integer> codes = new ArrayList<>();
        Pixel[] sourceMatrix = source.getPixels();
        for (int i = 0; i < sourceMatrix.length; i += 3) {
            int charNum = 0;
            List<Pixel> pixels = Arrays.asList(sourceMatrix[i], sourceMatrix[i + 1], sourceMatrix[i + 2]);
            for (int j = 0; j < pixels.size(); j++) {
                Pixel p = pixels.get(j);
                int decoded = SteganographyUtils.getLastTwoBits(p.getBlue());
                int base = (int) Math.pow(2, j * 2);
                charNum += decoded * base;
            }
            codes.add(charNum);
            if (charNum == 0) {
                break;
            }
        }
        return decodeString(codes);
    }

    private static boolean isSame(Picture pic1, Picture pic2) {
        Pixel[] pixels1 = pic1.getPixels();
        Pixel[] pixels2 = pic2.getPixels();
        for (int i = 0; i < pixels1.length; i++) {
            Color p1 = pixels1[i].getColor();
            Color p2 = pixels2[i].getColor();
            if (!p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Takes a string consisting of letters and spaces and * encodes the string into an arraylist of integers.
     * The integers are 1-26 for A-Z, 27 for space, and 0 for end of * string. The arraylist of integers is returned.
     *
     * @param s string consisting of letters and spaces
     * @return ArrayList containing integer encoding of uppercase version of s
     */
    public static ArrayList<Integer> encodeString(String s) {
        s = s.toUpperCase();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                result.add(27);
            } else {
                result.add(ALPHA.indexOf(s.charAt(i)) + 1);
            }
        }
        result.add(0);
        return result;
    }

    /**
     * Returns the string represented by the codes arraylist.
     * 1-26 = A-Z, 27 = space
     *
     * @param codes encoded string
     * @return decoded string
     */
    public static String decodeString(ArrayList<Integer> codes) {
        StringBuilder result = new StringBuilder();
        for (Integer code : codes) {
            if (code == 0) {
                return result.toString();
            }
            if (code == 27) {
                result.append(" ");
            } else {
                result.append(ALPHA.charAt(code - 1));
            }
        }
        return result.toString();
    }

    /*** Given a number from 0 to 63, creates and returns a 3--element
     *  int array consisting of the integers representing the
     *  pairs of bits in the number from right to left.
     * @param num number to be broken up
     * @return bit pairs in number
     */
    private static int[] getBitPairs(int num) {
        int[] bits = new int[3];
        int code = num;
        for (int i = 0; i < 3; i++) {
            bits[i] = code % 4;
            code = code / 4;
        }
        return bits;
    }
}
