package de.tu_bs.cs.isf.spl.simplecad.presentation;

public interface Canvas {
    void redraw(Runnable runnable);
    ShapeRenderer getShapeRenderer();
}
