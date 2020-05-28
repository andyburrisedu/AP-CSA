package com.andb.csa.notes.maze;

import java.util.*;

public class PerfectMaze {

    private static final Random random = new Random();

    int[][] roomIDs;
    ArrayList<Wall> walls = new ArrayList<>();

    public PerfectMaze(int rows, int columns) {
        roomIDs = new int[rows][columns];
        randomizeRoomIDs();
        initializeAllWalls();
        generateAllWalls();
    }

    private void randomizeRoomIDs() {
        ArrayList<Integer> usedIDs = new ArrayList<>();
        for (int row = 0; row < roomIDs.length; row++) {
            for (int col = 0; col < roomIDs[row].length; col++) {
                int id = generateUnusedID(usedIDs);
                roomIDs[row][col] = id;
                usedIDs.add(id);
            }
        }
    }

    private int generateUnusedID(List<Integer> usedIDs) {
        int id = random.nextInt(Integer.MAX_VALUE); // generates only positive values
        while (usedIDs.contains(id)) {
            id = random.nextInt();
        }
        return id;
    }

    private void initializeAllWalls() {
        for (int row = 0; row <= roomIDs.length; row++) {
            for (int col = 0; col <= roomIDs[0].length; col++) {
                initializeWallsForRoom(row, col);
            }
        }
    }

    private void initializeWallsForRoom(int row, int column) {
        Coordinate room = new Coordinate(row, column);
        Coordinate left = new Coordinate(row, column - 1);
        Coordinate above = new Coordinate(row - 1, column);

        Wall vertical = new Wall(left, room);
        Wall horizontal = new Wall(above, room);

        if (isStart(room) || isEnd(room)) {
            vertical.type = Wall.Type.BLANK;
        } else if (column - 1 < 0 || column >= columns()) {
            vertical.type = Wall.Type.SOLID;
        }

        if (row - 1 < 0 || row >= rows()) {
            horizontal.type = Wall.Type.SOLID;
        }

        if (isInMaze(vertical)) walls.add(vertical);
        if (isInMaze(horizontal)) walls.add(horizontal);
    }

    private boolean isInMaze(Wall wall) {
        boolean firstInMaze = Utils.between(wall.firstRoom.getColumn(), 0, columns()) && Utils.between(wall.firstRoom.getRow(), 0, rows());
        boolean secondInMaze = Utils.between(wall.secondRoom.getColumn(), 0, columns()) && Utils.between(wall.secondRoom.getRow(), 0, rows());
        return firstInMaze || secondInMaze;
    }

    private boolean isStart(Coordinate coordinate) { return coordinate.getRow() == 0 && coordinate.getColumn() == 0; }

    private boolean isEnd(Coordinate coordinate) { return coordinate.getRow() == rows() - 1 && coordinate.getColumn() == columns(); }

    private void generateAllWalls() {
        List<Wall> wallsToGo = new ArrayList<>(walls);
        Map<Integer, List<Coordinate>> idGroups = initialIDGroups();
        while (!wallsToGo.isEmpty()) {
            Wall wall = wallsToGo.get(random.nextInt(wallsToGo.size()));
            if (wall.type != Wall.Type.UNDECIDED) {
                wallsToGo.remove(wall);
                continue;
            }

            int firstRoomID = getRoomID(wall.firstRoom);
            int secondRoomID = getRoomID(wall.secondRoom);

            if (firstRoomID == secondRoomID) {
                wall.type = Wall.Type.SOLID;
            } else {
                wall.type = Wall.Type.BLANK;
                List<Coordinate> firstRoomGroup = idGroups.remove(firstRoomID);
                List<Coordinate> secondRoomGroup = idGroups.get(secondRoomID);
                secondRoomGroup.addAll(firstRoomGroup);
                idGroups.put(secondRoomID, secondRoomGroup);
                firstRoomGroup.forEach(c -> roomIDs[c.getRow()][c.getColumn()] = secondRoomID);
            }
            wallsToGo.remove(wall);
        }
    }

    private Map<Integer, List<Coordinate>> initialIDGroups() {
        Map<Integer, List<Coordinate>> groups = new HashMap<>();
        for (int row = 0; row < roomIDs.length; row++) {
            for (int col = 0; col < roomIDs[0].length; col++) {
                groups.put(roomIDs[row][col], Utils.arrayListOf(new Coordinate(row, col)));
            }
        }
        return groups;
    }

    public int rows() { return roomIDs.length; }

    public int columns() { return roomIDs[0].length; }

    public int getRoomID(Coordinate coordinate) { return roomIDs[coordinate.getRow()][coordinate.getColumn()]; }


}
