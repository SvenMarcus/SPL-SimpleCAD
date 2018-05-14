package de.tu_bs.cs.isf.spl.simplecad.model;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRenderer;

public class Rectangle implements Shape {

    private Point first;
    private Point second;

    public void setFirst(Point first) {
        this.first = first;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public void render(ShapeRenderer renderer) {
        int maxX = Math.max(first.getX(), second.getX());
        int minX = Math.min(first.getX(), second.getX());
        int maxY = Math.max(first.getY(), second.getY());
        int minY = Math.min(first.getY(), second.getY());
        renderer.renderRectangle(minX, minY, maxX, maxY);
    }
}
