package com.andb.csa.notes.maze;

import java.util.List;
import java.util.stream.Collectors;

public class MazeSolver {
    PerfectMaze maze;

    public MazeSolver(PerfectMaze maze) {
        this.maze = maze;
    }

    public List<Coordinate> getSolvePath() {
        List<VisitedCoordinate> path = Utils.arrayListOf(new VisitedCoordinate(0, 0));
        System.out.println("maze.walls = " + maze.walls);

        Coordinate end = new Coordinate(maze.rows() - 1, maze.columns() - 1);
        while (!path.get(path.size() - 1).coordinate.equals(end)) {
            VisitedCoordinate room = getNextRoom(path.get(path.size() - 1));
            if (room == null) {
                path.remove(path.size() - 1);
            } else {
                path.add(room);
            }
        }

        return path.stream().map(v -> v.coordinate).collect(Collectors.toList());
    }

    private VisitedCoordinate getNextRoom(VisitedCoordinate visitedCoordinate) {
        if (!visitedCoordinate.visitedNorth
                && maze.walls.stream()
                .filter(w -> w.secondRoom.equals(visitedCoordinate.coordinate) && w.isHorizontal())
                .findFirst()
                .get()
                .type == Wall.Type.BLANK
        ) {
            visitedCoordinate.visitedNorth = true;
            VisitedCoordinate next = new VisitedCoordinate(visitedCoordinate.coordinate.getRow() - 1, visitedCoordinate.coordinate.getColumn());
            next.visitedSouth = true;
            return next;
        } else if (!visitedCoordinate.visitedSouth
                && maze.walls.stream()
                .filter(w -> w.firstRoom.equals(visitedCoordinate.coordinate) && w.isHorizontal())
                .findFirst()
                .get()
                .type == Wall.Type.BLANK
        ) {
            visitedCoordinate.visitedSouth = true;
            VisitedCoordinate next = new VisitedCoordinate(visitedCoordinate.coordinate.getRow() + 1, visitedCoordinate.coordinate.getColumn());
            next.visitedNorth = true;
            return next;
        } else if (!visitedCoordinate.visitedWest
                && visitedCoordinate.coordinate.getColumn() > 0 // make sure it does not leave the start
                && maze.walls.stream()
                .filter(w -> w.secondRoom.equals(visitedCoordinate.coordinate) && !w.isHorizontal())
                .findFirst()
                .get()
                .type == Wall.Type.BLANK
        ) {
            visitedCoordinate.visitedWest = true;
            VisitedCoordinate next = new VisitedCoordinate(visitedCoordinate.coordinate.getRow(), visitedCoordinate.coordinate.getColumn() - 1);
            next.visitedEast = true;
            return next;
        } else if (!visitedCoordinate.visitedEast
                && maze.walls.stream()
                .filter(w -> w.firstRoom.equals(visitedCoordinate.coordinate) && !w.isHorizontal())
                .findFirst()
                .get()
                .type == Wall.Type.BLANK
        ) {
            visitedCoordinate.visitedEast = true;
            VisitedCoordinate next = new VisitedCoordinate(visitedCoordinate.coordinate.getRow(), visitedCoordinate.coordinate.getColumn() + 1);
            next.visitedWest = true;
            return next;
        } else {
            return null;
        }
    }

    private class VisitedCoordinate {
        boolean visitedNorth = false;
        boolean visitedSouth = false;
        boolean visitedWest = false;
        boolean visitedEast = false;
        Coordinate coordinate;

        public VisitedCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
        }

        public VisitedCoordinate(int row, int column) {
            this.coordinate = new Coordinate(row, column);
        }

        @Override
        public String toString() {
            return "VisitedCoordinate{" +
                    "visitedNorth=" + visitedNorth +
                    ", visitedSouth=" + visitedSouth +
                    ", visitedWest=" + visitedWest +
                    ", visitedEast=" + visitedEast +
                    ", coordinate=" + coordinate +
                    '}';
        }
    }
}
