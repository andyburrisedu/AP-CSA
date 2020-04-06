package com.andb.csa.term2.assignments.assignment5;

/* Term 2 Assignment 5 - Game Wheel */
/* Slice class*/
public class Slice {
    private String color;
    private int prizeAmount;


    // Creates a slice with color c, and cash prize p
    public Slice(String color, int prizeAmount) {
        this.color = color;
        this.prizeAmount = prizeAmount;
    }


    // Returns the cash prize in dollars for this slice
    public int getPrizeAmount() {
        return prizeAmount;
    }


    // Returns the color of this slice as a string
    public String getColor() {
        return color;
    }


    /* Returns a string representation of the slice in the following format:
     * �Color: red, prize amount: $50�.
     */
    public String toString() {
        return "Color: " + color + ", Prize Amount: $" + prizeAmount;
    }
}