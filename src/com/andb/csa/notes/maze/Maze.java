package com.andb.csa.notes.maze;

import java.util.Random;

public class Maze {
    Room[][] rooms;
    Coordinate start;

    public Maze(int rows, int columns) {
        Random random = new Random();
        start = new Coordinate(random.nextInt(rows), random.nextInt(columns));
        Coordinate end = new Coordinate(random.nextInt(rows), random.nextInt(columns));
        rooms = new Room[rows][columns];
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                Coordinate currentCoordinate = new Coordinate(row, col);
                Room room;
                if (currentCoordinate.equals(start)) {
                    room = new Room(Room.Type.START);
                } else if (currentCoordinate.equals(end)) {
                    room = new Room(Room.Type.END);
                } else {
                    room = new Room(Room.randomType(random));
                }
                rooms[row][col] = room;
            }
        }
    }

    public boolean isSolvable() {
        Coordinate current = new Coordinate(start.getRow(), start.getColumn());
        Direction currentDirection = Direction.NORTH;
        while (true) {
            Room forward = getForward(current, currentDirection);
            if (forward == null || forward.type == Room.Type.FILLED) {
                currentDirection = currentDirection.ccw();
            } else if (forward.type == Room.Type.EMPTY) {
                current.move(currentDirection);
                currentDirection = currentDirection.cw();
            } else if (forward.type == Room.Type.END) {
                return true;
            } else if (forward.type == Room.Type.START) {
                return false;
            }
        }
    }

    public Room getForward(Coordinate currentCoord, Direction currentDirection) {
        Coordinate copy = new Coordinate(currentCoord.getRow(), currentCoord.getColumn());
        copy.move(currentDirection);
        if (0 > copy.getRow() || copy.getRow() >= rooms.length || 0 > copy.getColumn() || copy.getColumn() >= rooms[0].length)
            return null;
        return rooms[copy.getRow()][copy.getColumn()];
    }

    public Room getRight(Coordinate currentCoord, Direction currentDirection) {
        int newRow = (currentDirection == Direction.NORTH) ? currentCoord.getRow() - 1 : (currentDirection == Direction.SOUTH) ? currentCoord.getRow() + 1 : currentCoord.getRow();
        int newCol = (currentDirection == Direction.WEST) ? currentCoord.getColumn() - 1 : (currentDirection == Direction.EAST) ? currentCoord.getColumn() + 1 : currentCoord.getColumn();
        return rooms[newRow][newCol];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Room[] row : rooms) {
            for (Room room : row) {
                switch (room.type) {
                    case START:
                        sb.append("S");
                        break;
                    case END:
                        sb.append("E");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                    case FILLED:
                        sb.append("█");
                        break;
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Maze maze = new Maze(10, 10);
        System.out.println(maze);
        System.out.println(maze.isSolvable());
    }
}
