package de.tu_bs.cs.isf.spl.simplecad.presentation;

public class ShapeBuilderFactoryImpl implements ShapeBuilderFactory {
    public ShapeBuilder makeShapeBuilder(String type) {
        if(type.equals("Line"))
            return new LineBuilder();
        else if(type.equals("Rectangle"))
            return new RectangleBuilder();
        else if(type.equals("Node"))
            return new NodeBuilder();
        throw new InvalidBuilderTypeException(type);
    }

}

class InvalidBuilderTypeException extends RuntimeException {
    InvalidBuilderTypeException(String builderType) {
        super("Invalid BuilderType " + builderType);
    }
}
