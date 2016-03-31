package com.dismas.imaya.drawingfirebase;

/**
 * Created by imaya on 4/1/16.
 */
public class Point {
    int x;
    int y;

    // Required default constructor for Firebase serialization / deserialization
    @SuppressWarnings("unused")
    private Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}