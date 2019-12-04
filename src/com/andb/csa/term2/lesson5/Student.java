package com.andb.csa.term2.lesson5;

public class Student {
    private static int nextID = 1;

    String firstName;
    String lastName;
    int gradeLevel;
    double gpa;
    int id;

    public Student() {
        this.firstName = "None";
        this.lastName = "None";
        this.gradeLevel = 0;
        this.gpa = 0;
        this.id = nextID;
        nextID++;
    }

    public Student(String firstName, String lastName, int gradeLevel, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
        if (gradeLevel < 0 || 12 < gradeLevel) {
            this.gradeLevel = 0;
        }
        this.gpa = gpa;
        if (gpa < 0 || 4.5 < gpa) {
            this.gpa = 0;
        }
        this.id = nextID;
        nextID++;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + "\n" +
                "GPA: " + gpa + "\n" +
                "Grade Level: " + gradeLevel + " id # " + id;
    }
}
