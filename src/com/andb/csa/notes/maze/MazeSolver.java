package com.andb.csa.notes.maze;

import java.util.List;

public class MazeSolver {
    Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public List<Coordinate> getSolvePath() {
        List<Coordinate> finalPath = Utils.arrayListOf(new Coordinate(0, 0));

        return finalPath;
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
    }
}
