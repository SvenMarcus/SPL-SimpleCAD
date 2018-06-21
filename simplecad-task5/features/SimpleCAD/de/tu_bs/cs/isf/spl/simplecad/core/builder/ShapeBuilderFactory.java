package de.tu_bs.cs.isf.spl.simplecad.core.builder;


public interface ShapeBuilderFactory {
    ShapeBuilder makeShapeBuilder(String shapeBuilder);
}
