package de.tu_bs.cs.isf.spl.simplecad.presentation.textinput;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.presentation.BuildShapeStrategy;
import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.presentation.builder.ShapeBuilder;

public class KeyboardInputParser {

    private ShapeBuilderFactory shapeBuilderFactory;
    private BuildShapeStrategy buildShapeStrategy;
    private TextField textField;

    public KeyboardInputParser(ShapeBuilderFactory shapeBuilderFactory, BuildShapeStrategy buildShapeStrategy, TextField textField) {
        this.shapeBuilderFactory = shapeBuilderFactory;
        this.buildShapeStrategy = buildShapeStrategy;
        this.textField = textField;
    }

    public void process(String command) {
        textField.clear();
        if (!buildShapeStrategy.hasBuilder()) {
            ShapeBuilder shapeBuilder = tryMakeShapeBuilder(command);
            setShapeBuilderInStrategy(shapeBuilder);
        } else
            addPoint(command);
    }

    private void setShapeBuilderInStrategy(ShapeBuilder shapeBuilder) {
        if (shapeBuilder != null)
            buildShapeStrategy.setShapeBuilder(shapeBuilder);
    }

    private void addPoint(String command) {
        Point point = parsePoint(command);
        if (point != null)
            buildShapeStrategy.addPoint(point);
    }

    private Point parsePoint(String command) {
        command = command.replaceAll(" ", "");
        String[] coordinates = command.split(",");
        int x, y;
        x = y = 0;
        try {
            if (coordinates.length >= 2) {
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
            }
        } catch (Exception ignored) {
            textField.setText("Invalid Point");
            return null;
        }

        return new Point(x, y);
    }

    private ShapeBuilder tryMakeShapeBuilder(String command) {
        try {
            return shapeBuilderFactory.makeShapeBuilder(command);
        } catch (Exception ignored) {
            textField.setText("Invalid Shape Type");
        }
        return null;
    }
}
