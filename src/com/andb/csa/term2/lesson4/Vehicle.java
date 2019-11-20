package com.andb.csa.term2.lesson4;

public class Vehicle {
    private int location;

    public Vehicle() {
        this(0);
    }

    public Vehicle(int location) {
        if (-20 <= location && location <= 20) {
            this.location = location;
        } else {
            this.location = 0;
        }
    }

    void forward() {
        if (location < 20) {
            location++;
        }
    }

    void backward() {
        if (location > -20) {
            location--;
        }
    }

    int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = -20; i < location; i++) {
            sb.append(" ");
        }
        sb.append("@");
        return sb.toString();
    }
}
