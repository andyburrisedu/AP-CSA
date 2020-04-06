package com.andb.csa.term2.assignments.assignment5;
/* Term 2 Assignment 5 - Game Wheel */
/* GameWheel class*/

import java.util.ArrayList;
import java.util.List;

public class GameWheel {
    // List of slices making up the wheel
    private List<Slice> slices;

    // Position of currently selected slice on wheel
    private int currentPos;


    /* Creates a wheel with 40 preset slices which are then randomized (keeping
     * the color pattern the same).
     */
    public GameWheel() {
        slices = new ArrayList<>();
        currentPos = 0;
        initGameWheel();
        scramble();
    }

    public List<Slice> getSlices() {
        return slices;
    }

    /* Spins the wheel by so that a different slice is selected. Return that
     * slice (Note: the 20 slices following the current slice are more likely to
     * be returned than the other 20).
     */
    public Slice spinWheel() {
        //spin power between range of 1-100 (inclusive)
        int power = (int) (Math.random() * 100 + 1);
        int newPos = (currentPos + power) % slices.size();
        currentPos = newPos;
        return slices.get(currentPos);
    }


    /* Helper method for the constructor. Randomizes the positions of the slices
     * that are in the wheel, but without changing the pattern of the colors
     * (i.e. the red slices will still be at odd indices, the black slices at
     * multiples of 10, and the blue slices at all other even indices).
     */
    private void scramble() {
        ArrayList<Slice> newList = new ArrayList<>();
        List<Slice> blackSlices = filterColor(slices, "black");
        List<Slice> redSlices = filterColor(slices, "red");
        List<Slice> blueSlices = filterColor(slices, "blue");

        for (int i = 0; i < 40; i++) {
            if (i % 2 == 1)
                newList.add(removeRandom(redSlices));
            else if (i % 10 == 0)
                newList.add(removeRandom(blackSlices));
            else
                newList.add(removeRandom(blueSlices));
        }
        slices = newList;
    }

    private static List<Slice> filterColor(List<Slice> list, String color) {
        ArrayList<Slice> result = new ArrayList<>();
        for (Slice s : list) {
            if (s.getColor().equals(color)) {
                result.add(s);
            }
        }
        return result;
    }

    private static <T> T removeRandom(List<T> list) {
        int randomIndex = random(0, list.size());
        return list.remove(randomIndex);
    }

    /**
     * Calculates random integer within a range
     *
     * @param baseInclusive    Bottom of random range (possible to be a returned value)
     * @param ceilingExclusive Top of random range (can't be a returned value)
     * @return Random integer in range
     */
    public static int random(int baseInclusive, int ceilingExclusive) {
        int range = ceilingExclusive - baseInclusive;
        return (int) (Math.random() * range + baseInclusive);
    }


    // Helper method which initializes the slices in the wheel
    private void initGameWheel() {
        slices.add(new Slice("black", 8000));
        for (int i = 1; i < 40; i++) {
            if (i % 2 == 1)
                slices.add(new Slice("red", i * 10));
            else if (i % 10 == 0)
                slices.add(new Slice("black", i * 200));
            else
                slices.add(new Slice("blue", i * 100));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        slices.forEach(slice -> sb.append(slice).append("\n"));
        return "Game Wheel: \n" + sb.toString();
    }
}
