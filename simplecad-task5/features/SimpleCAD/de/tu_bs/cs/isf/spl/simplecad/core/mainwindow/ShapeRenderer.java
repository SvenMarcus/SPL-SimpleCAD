package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow;

public interface ShapeRenderer {
    void renderLine(int x1, int y1, int x2, int y2);
    void renderRectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY);
    void renderNode(int x, int y);
}
