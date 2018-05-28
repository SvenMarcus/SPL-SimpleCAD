package de.tu_bs.cs.isf.spl.simplecad.presentation;

public class BeginDrawTransaction {

    private final ShapeBuilderFactoryImpl builderFactory;
    private final String type;
    private BuildShapeStrategy shapeStrategy;

    public BeginDrawTransaction(String type, BuildShapeStrategy shapeStrategy) {
        this.type = type;
        this.shapeStrategy = shapeStrategy;
        this.builderFactory = new ShapeBuilderFactoryImpl();
    }

    public void execute() {
        shapeStrategy.setShapeBuilder(builderFactory.makeShapeBuilder(type));
    }

    public String getShapeType() {
        return type;
    }
}
