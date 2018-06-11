package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow;

import de.tu_bs.cs.isf.spl.simplecad.core.input.MouseInputHandler;

public interface Canvas {
    void redraw(Runnable runnable);

    void setMouseInputHandler(MouseInputHandler inputHandler);

    ShapeRenderer getShapeRenderer();
}
