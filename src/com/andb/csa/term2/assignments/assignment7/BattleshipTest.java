package com.andb.csa.term2.assignments.assignment7;

public class BattleshipTest {
    public static void main(String[] args) {
        Board board = new Board();
        board.addShip(0, 4, 3, false);
        board.addShip(5, 2, 5, true);
        //board.addShip(0, 7, 3, true);

        //shouldn't add
        board.addShip(4, 7, 4, true);
        board.addShip(-1, 7, 4, true);
        board.addShip(1, 2, 3, true);


        board.shoot(5, 2);
        System.out.println(board);
    }
}
