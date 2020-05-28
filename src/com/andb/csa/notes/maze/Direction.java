package com.andb.csa.notes.maze;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public Direction cw() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            default:
                throw new Error("Unsupported enum");
        }
    }

    public Direction ccw() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            default:
                throw new Error("Unsupported enum");
        }
    }
}
