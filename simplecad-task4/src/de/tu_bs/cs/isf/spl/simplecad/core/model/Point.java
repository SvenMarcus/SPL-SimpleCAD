package de.tu_bs.cs.isf.spl.simplecad.core.model;

public class Point {

    private final int x;
    private final int y;


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

    public double distanceTo(Point point) {
        int dx = Math.abs(x - point.x);
        int dy = Math.abs(y - point.y);
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
