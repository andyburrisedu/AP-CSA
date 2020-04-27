package com.andb.csa.term2.assignments.assignment7;

import java.util.Arrays;

public class Board {
    private static int BOARD_SIZE = 10;

    private char[][] squares;

    public Board() {
        squares = new char[BOARD_SIZE][BOARD_SIZE];
        for (char[] row : squares) {
            Arrays.fill(row, '-');
        }
    }

    public boolean addShip(int row, int column, int len, boolean horizontal) {
        if (row < 0 || BOARD_SIZE <= row || column < 0 || BOARD_SIZE <= column || len < 1 || (horizontal && column + len > BOARD_SIZE) || (!horizontal && row + len > BOARD_SIZE)) {
            return false;
        }

        Coordinate[] boatCoordinates = new Coordinate[len];

        for (int i = 0; i < len; i++) {
            int x = horizontal ? column + i : column;
            int y = horizontal ? row : row + i;
            boatCoordinates[i] = new Coordinate(x, y);
        }

        if (Arrays.stream(boatCoordinates).anyMatch(c -> squares[c.y][c.x] == 'b')) {
            return false;
        }

        if (horizontal) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (column <= c && c < column + len) {
                    squares[row][c] = 'b';
                }
            }
        } else {
            for (int r = 0; r < BOARD_SIZE; r++) {
                if (row <= r && r < row + len) {
                    squares[r][column] = 'b';
                }
            }
        }
        return true;
    }

    public int shoot(int row, int col) {
        if (row >= BOARD_SIZE || col >= BOARD_SIZE) {
            return -1;
        }
        if (squares[row][col] == '-') {
            squares[row][col] = 'm';
            return 0;
        } else if (squares[row][col] == 'b') {
            squares[row][col] = 'x';
            return 1;
        } else { //already shot
            return 2;
        }
    }

    public boolean gameOver() {
        for (char[] row : squares) {
            for (char c : row) {
                if (c == 'b') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean foundShip(int len) {
        return searchShipHorz(squares, len) || searchShipHorz(pivot(squares), len);
    }

    private boolean searchShipHorz(char[][] board, int len) {
        for (char[] row : board) {
            int streak = 0;
            for (char c : row) {
                if (c == 'b') {
                    streak++;
                } else {
                    if (streak == len) {
                        return true;
                    }
                    streak = 0;
                }
            }
            if (streak == len) {
                return true;
            }
        }
        return false;
    }

    private char[][] pivot(char[][] source) {
        char[][] out = new char[source[0].length][source.length];

        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                out[c][r] = source[r][c];
            }
        }

        return out;
    }

    @Override
    public String toString() {
        boolean showNumbers = false;
        StringBuilder sb = new StringBuilder(showNumbers ? "  0 1 2 3 4 5 6 7 8 9" : "");
        for (int r = 0; r < squares.length; r++) {
            sb.append(showNumbers || r != 0 ? "\n" : "").append(showNumbers ? r + " " : "");
            for (int c = 0; c < squares[r].length; c++) {
                sb.append(squares[r][c]).append(" ");
            }
        }
        return sb.toString();
    }

    class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
