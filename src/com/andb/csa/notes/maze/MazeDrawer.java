package com.andb.csa.notes.maze;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MazeDrawer extends JPanel {
    private PerfectMaze maze;
    private MazeSolver mazeSolver;

    public int roomWidth() { return this.getWidth() / maze.columns();}

    public int roomHeight() { return this.getHeight() / maze.rows();}

    public MazeDrawer(PerfectMaze maze) {
        this.maze = maze;
    }

    public MazeDrawer(PerfectMaze maze, MazeSolver mazeSolver) {
        this.maze = maze;
        this.mazeSolver = mazeSolver;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        paintRooms((Graphics2D) g);
        if (mazeSolver != null) {
            paintSolution((Graphics2D) g);
        }
        paintWalls((Graphics2D) g);
    }

    private void paintRooms(Graphics2D g) {
        for (int y = 0; y < maze.rows(); y++) {
            for (int x = 0; x < maze.columns(); x++) {
                int id = maze.roomIDs[y][x];
                Color color = new Color(Utils.colorFromID(id));
                g.setColor(color);
                g.fillRect(x * roomWidth(), y * roomHeight(), roomWidth(), roomHeight());
            }
        }
    }

    private void paintWalls(Graphics2D g) {
        for (Wall wall : maze.walls) {
            if (wall.type == Wall.Type.BLANK) continue;
            Color color = (wall.type == Wall.Type.UNDECIDED) ? Color.GRAY : (wall.type == Wall.Type.SOLID) ? Color.BLACK : Color.WHITE;
            Coordinate room = wall.secondRoom;
            g.setColor(color);
            if (wall.isHorizontal()) {
                g.fillRect(room.getColumn() * roomWidth(), room.getRow() * roomHeight() - 2, roomWidth(), 4);
            } else {
                g.fillRect(room.getColumn() * roomWidth() - 2, room.getRow() * roomHeight(), 4, roomHeight());
            }
        }
    }

    private void paintSolution(Graphics2D g) {
        List<Coordinate> path = mazeSolver.getSolvePath();
        Color color = new Color(Utils.colorFromID(maze.roomIDs[0][0])).darker().darker();
        //color = Color.WHITE;
        g.setColor(color);
        for (Coordinate coordinate : path) {
            g.fillRect(coordinate.getColumn() * roomWidth(), coordinate.getRow() * roomHeight(), roomWidth(), roomHeight());
        }
    }

    public static void main(String[] args) {
        PerfectMaze maze = new PerfectMaze(100, 100);
        MazeSolver solver = new MazeSolver(maze);
        //System.out.println(solver.getSolvePath());
        JFrame frame = new JFrame();
        MazeDrawer drawer = new MazeDrawer(maze, solver);
        frame.add(drawer);
        frame.setSize(800, 800);
        frame.setTitle("Maze Generator");
        frame.setVisible(true);
    }

}
