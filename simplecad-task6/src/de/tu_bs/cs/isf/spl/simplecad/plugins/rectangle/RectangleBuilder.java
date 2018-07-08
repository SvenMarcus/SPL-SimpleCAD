package de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle;

import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;

public class RectangleBuilder extends ShapeBuilder {
    private int pointsAdded;
    private Rectangle rectangle;

    public void addPoint(Point point) {
        pointsAdded++;
        if (rectangle == null)
            rectangle = (Rectangle) makeShape();
        if (pointsAdded == 1)
            rectangle.setFirst(point);
        else if (pointsAdded == 2)
            rectangle.setSecond(point);
    }

    public boolean isShapeFinished() {
        return pointsAdded > 1;
    }

    public Shape getShape() {
        if (rectangle == null)
            rectangle = (Rectangle) makeShape();
        return rectangle;
    }

    protected Shape makeShape() {
        return new Rectangle();
    }
}
