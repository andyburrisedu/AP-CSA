package com.andb.csa.notes.graphics;

import com.andb.csa.library.StdDraw;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;

/**
 * Draws IntelliJ IDEA Logo
 *
 * @author Andy Burris
 * @version 1 December 2019
 */
public class StdDrawAssignment {
    public static void main(String[] args) {
        drawBackground();
        drawBase();
        drawText();
        drawBar();
    }

    public static void drawBase() {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(.5, .5, .325, .325);
    }

    public static void drawText() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.setFont(getFont());
        StdDraw.text(.3395, .525, "I");
        StdDraw.text(.55, .525, "J");

        //Draw "I" bars since Gotham-Medium is sans-serif (modified brand font?)
        StdDraw.filledRectangle(.34, .7, .06, .0225);
        StdDraw.filledRectangle(.34, .465, .06, .0225);
    }

    public static void drawBar() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(.25 + .125, .26 + .015, .125, .015);
    }

    public static void drawBackground() {
        drawShape2();
        drawShape3();
        drawShape1();
        drawShape4();
    }

    public static void drawShape1() {
        ArrayList<Pair<Double, Double>> shape1 = new ArrayList<>();
        shape1.add(new Pair<>(0.0, 0.6));
        shape1.add(new Pair<>(.15, 1.0));
        shape1.add(new Pair<>(.45, .96));
        shape1.add(new Pair<>(.8, .61));
        shape1.add(new Pair<>(.6, .5));
        drawPolygon(new Color(254, 49, 93), shape1);
    }

    public static void drawShape2() {
        ArrayList<Pair<Double, Double>> shape2 = new ArrayList<>();
        shape2.add(new Pair<>(0.01, 0.4));
        shape2.add(new Pair<>(0.175, 0.25));
        shape2.add(new Pair<>(0.5, 0.5));
        shape2.add(new Pair<>(0.175, 0.7));
        drawPolygon(new Color(249, 122, 18), shape2);
    }

    public static void drawShape3() {
        ArrayList<Pair<Double, Double>> shape3 = new ArrayList<>();
        shape3.add(new Pair<>(0.65, 0.98));
        shape3.add(new Pair<>(1.0, 0.7));
        shape3.add(new Pair<>(0.98, 0.17));
        shape3.add(new Pair<>(0.575, 0.0));
        shape3.add(new Pair<>(0.25, 0.175));
        shape3.add(new Pair<>(0.55, 0.825));
        drawPolygon(new Color(10, 123, 249), shape3);
    }

    public static void drawShape4() {
        ArrayList<Pair<Double, Double>> shape4 = new ArrayList<>();
        shape4.add(new Pair<>(0.1, 0.04));
        shape4.add(new Pair<>(0.175, 0.4));
        shape4.add(new Pair<>(0.5, 0.175));
        drawPolygon(new Color(150, 81, 159), shape4);
    }

    public static Font getFont() {
        Font font = null;

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts(); // Get the fonts
        for (Font f : fonts) {
            if (f.getFontName().equals("Gotham-Medium")) {
                font = f;
            }
        }
        System.out.println(font.getSize());

        return Font.getFont("Gotham-Medium", font.deriveFont(200f));
    }

    public static <K, V> Pair<ArrayList<K>, ArrayList<V>> split(ArrayList<Pair<K, V>> arrayList) {
        ArrayList<K> k = new ArrayList<>();
        ArrayList<V> v = new ArrayList<>();
        for (Pair<K, V> pair : arrayList) {
            k.add(pair.getKey());
            v.add(pair.getValue());
        }
        return new Pair<>(k, v);
    }

    public static void drawPolygon(Color color, ArrayList<Pair<Double, Double>> coordinates) {
        StdDraw.setPenColor(color);
        Pair<ArrayList<Double>, ArrayList<Double>> split = split(coordinates);
        StdDraw.filledPolygon(split.getKey().stream().mapToDouble(d -> d).toArray(), split.getValue().stream().mapToDouble(d -> d).toArray());
    }
}
