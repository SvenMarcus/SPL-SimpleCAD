package de.tu_bs.cs.isf.spl.simplecad.model;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRenderer;

public class Line implements Shape {

    private Point first;
    private Point second;

    public void setFirst(Point first) {
        this.first = first;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public boolean isPointOnBoundary(Point point, int radius) {
        int x0 = point.getX();
        int x1 = first.getX();
        int x2 = second.getX();

        int y0 = point.getY();
        int y1 = first.getY();
        int y2 = second.getY();

        double dist = Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1) / (second.distanceTo(first));

        return dist <= radius;
    }

    public void render(ShapeRenderer renderer) {
        renderer.renderLine(first.getX(), first.getY(), second.getX(), second.getY());
    }
}
