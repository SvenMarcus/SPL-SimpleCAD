package de.tu_bs.cs.isf.spl.simplecad.core.builder;


public interface ShapeBuilderFactory {
    ShapeBuilder makeShapeBuilder(String shapeBuilder);

    void registerShapeBuilder(String shapeName, Class<? extends ShapeBuilder> builderClass);
}
