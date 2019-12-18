package com.andb.csa.term2.assignments.assignment3;

public class UltimatePlayer extends Person {
    private static int nextJersey = 1;
    public static final String POSITION_HANDLER = "handler";
    public static final String POSITION_CUTTER = "cutter";

    private int jerseyNumber;
    private String position;

    public UltimatePlayer(String firstName, String lastName, String position) {
        super(firstName, lastName);
        if (position.equals(POSITION_HANDLER) || position.equals(POSITION_CUTTER)) {
            this.position = position;
        } else {
            this.position = POSITION_HANDLER;
        }
        jerseyNumber = nextJersey;
        nextJersey++;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Jersey #: " + jerseyNumber + "\n   Position: " + position;
    }
}
