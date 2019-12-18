package com.andb.csa.notes.graphics.animation;

import com.andb.csa.library.StdDraw;
import com.andb.csa.library.Utils;

import java.util.ArrayList;

/**
 * Practice animation
 */
public class Bounce {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            balls.add(new Ball(
                    Utils.random(0.0, 1.0),
                    Utils.random(0.0, 1.0),
                    Utils.random(0, 360),
                    0.01,
                    Utils.randomColor()
            ));
        }

        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            for (Ball ball : balls) {
                draw(ball);
                update(ball);
            }
            StdDraw.pause(1000 / 60);
            StdDraw.show();
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
        ball.updateGravity();
    }

    public static void debug(Ball ball) {
        String debug = "yVel: " + ball.getYVel() + ", xVel: " + ball.getXVel();
        StdDraw.text(0.1, 0.9, debug);
    }
}
