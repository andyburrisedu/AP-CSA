package com.andb.csa.term2.assignments.assignment3;

public class Captain extends UltimatePlayer {
    private boolean type;

    public Captain(String firstName, String lastName, String position, boolean type) {
        super(firstName, lastName, position);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Captain: " + (type ? "offense" : "defense");
    }
}
