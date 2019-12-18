package com.andb.csa.term2.assignments.assignment3;

public class Coach extends Person {
    private String role;

    public Coach(String firstName, String lastName, String role) {
        super(firstName, lastName);
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Role: " + role;
    }
}
