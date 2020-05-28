package com.andb.csa.notes.maze;

public class Wall {

    public Type type = Type.UNDECIDED;
    final Coordinate firstRoom;
    final Coordinate secondRoom;

    public Wall(Coordinate firstRoom, Coordinate secondRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

    public boolean isHorizontal() {
        return firstRoom.getColumn() == secondRoom.getColumn();
    }

    enum Type {
        UNDECIDED, BLANK, SOLID
    }

    @Override
    public String toString() {
        return "Wall{" +
                "type=" + type +
                ", firstRoom=" + firstRoom +
                ", secondRoom=" + secondRoom +
                '}';
    }
}
