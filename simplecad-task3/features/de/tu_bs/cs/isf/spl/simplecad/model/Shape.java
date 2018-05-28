package de.tu_bs.cs.isf.spl.simplecad.model;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRenderer;

public interface Shape {
    boolean isPointOnBoundary(Point point, int radius);
    void render(ShapeRenderer renderer);
}
