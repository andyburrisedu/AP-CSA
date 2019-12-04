package com.andb.csa.notes.graphics.animation;

import java.awt.*;

public class Ball {

    public static final double GRAVITY = -9.32 / 1000;

    private double x;
    private double y;
    private int direction;
    private double radius;
    private Color color;

    public Ball(double x, double y, int direction, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    public double getXVel() {
        return (Math.cos(Math.toRadians(direction))) / 1000;
    }

    public double getYVel() {
        return (Math.sin(Math.toRadians(direction))) / 1000;
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
        direction = 180 - direction;
    }

    public void bounceY() {
        direction = 360 - direction;
    }
}
