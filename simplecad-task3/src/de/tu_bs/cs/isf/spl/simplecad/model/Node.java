package de.tu_bs.cs.isf.spl.simplecad.model;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRenderer;

public class Node implements Shape {

    private Point first;

    public void setFirst(Point first) {
        this.first = first;
    }

    public boolean isPointOnBoundary(Point point, int radius) {
        return first.distanceTo(point) <= radius;
    }

    public void render(ShapeRenderer renderer) {
        renderer.renderNode(first.getX(), first.getY());
    }
}
