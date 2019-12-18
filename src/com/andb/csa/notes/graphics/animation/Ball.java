package com.andb.csa.notes.graphics.animation;

import java.awt.*;

public class Ball {

    public static final double GRAVITY = -9.32E-4;
    public static final double BOUNCE_FRICTION_DIRECT = .8;
    public static final double BOUNCE_FRICTION_INDIRECT = .95;
    //public static final double GRAVITY = -1E-4;

    private double x;
    private double y;
    private double xVel;
    private double yVel;
    private double radius;
    private Color color;

    public Ball(double x, double y, int direction, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.xVel = (Math.cos(Math.toRadians(direction))) / 100;
        this.yVel = (Math.sin(Math.toRadians(direction))) / 100;
        this.radius = radius;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXVel() {
        return xVel;
    }

    public double getYVel() {
        return yVel;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean atXEdge() {
        if (x + radius >= 1.0 || x - radius <= 0.0) {
            return true;
        }
        return false;
    }

    public boolean atYEdge() {
        if (y + radius >= 1.0 || y - radius <= 0.0) {
            return true;
        }
        return false;
    }

    public void bounceX() {
        if (x + radius >= 1.0) {
            x = 1.0 - radius;
        } else if (x - radius <= 0.0) {
            x = radius;
        }
        xVel = -xVel * BOUNCE_FRICTION_DIRECT;
        yVel = yVel * BOUNCE_FRICTION_INDIRECT;
    }

    public void bounceY() {
        if (y + radius >= 1.0) {
            y = 1.0 - radius;
        } else if (y - radius <= 0.0) {
            y = radius;
        }
        yVel = -yVel * BOUNCE_FRICTION_DIRECT;
        xVel = xVel * BOUNCE_FRICTION_INDIRECT;
    }

    public void updateGravity() {
        yVel += GRAVITY;
    }
}
