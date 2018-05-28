package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.presentation.builder.ShapeBuilder;

public interface ShapeBuilderFactory {
    ShapeBuilder makeShapeBuilder(String shapeBuilder);
}
