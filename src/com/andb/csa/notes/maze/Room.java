package com.andb.csa.notes.maze;

import java.util.Random;

public class Room {
    public Type type;

    public Room(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type=" + type +
                '}';
    }

    enum Type {
        START, END, EMPTY, FILLED
    }

    public static Type randomType(Random random) {
        int type = random.nextInt(2);
        switch (type) {
            case 0:
                return Type.EMPTY;
            case 1:
                return Type.FILLED;
            default:
                throw new Error("Random returned " + type + ", should be either 0 or 1");
        }
    }
}
