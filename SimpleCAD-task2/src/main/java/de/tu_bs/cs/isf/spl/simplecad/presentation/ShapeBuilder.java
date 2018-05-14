package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public abstract class ShapeBuilder {

    public abstract void addPoint(Point point);
    public abstract boolean isObjectFinished();
    public abstract Shape getShape();
    protected abstract Shape makeShape();

}
