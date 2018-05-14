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

    public void render(ShapeRenderer renderer) {
        renderer.renderLine(first.getX(), first.getY(), second.getX(), second.getY());
    }
}
