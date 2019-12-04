package com.andb.csa.notes.graphics.animation;

import com.andb.csa.library.StdDraw;

import java.awt.*;

/**
 * Practice animation
 */
public class Bounce {
    public static void main(String[] args) {
        Ball ball = new Ball(0.5, 0.5, 30, 0.01, Color.BLUE);

        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            draw(ball);
            StdDraw.show();
            update(ball);
        }
    }

    public static void draw(Ball ball) {
        StdDraw.setPenColor(ball.getColor());
        StdDraw.circle(ball.getX(), ball.getY(), ball.getRadius());
        //debug(ball);
    }

    public static void update(Ball ball) {
        ball.setX(ball.getX() + ball.getXVel());
        ball.setY(ball.getY() + ball.getYVel());
        if (ball.atXEdge()) {
            ball.bounceX();
        }
        if (ball.atYEdge()) {
            ball.bounceY();
        }
    }

    public static void debug(Ball ball) {
        String debug = "direction: " + ball.getDirection() + ", xVel: " + ball.getXVel();
        StdDraw.text(0.1, 0.9, debug);
    }
}
