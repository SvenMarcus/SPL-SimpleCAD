package de.tu_bs.cs.isf.spl.simplecad.impl;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactoryImpl;
import de.tu_bs.cs.isf.spl.simplecad.plugins.delete.DeleteCommand;
import de.tu_bs.cs.isf.spl.simplecad.plugins.line.LineBuilder;
import de.tu_bs.cs.isf.spl.simplecad.plugins.movepoint.PointMoveCommand;
import de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape.ShapeMoveCommand;
import de.tu_bs.cs.isf.spl.simplecad.plugins.node.NodeBuilder;
import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.RectangleBuilder;

public class Main {
    public static void main(String[] args) {
        SwingComponentFactory factory = new SwingComponentFactory();
        ShapeBuilderFactoryImpl shapeBuilderFactory = new ShapeBuilderFactoryImpl();
        CADApplication app = new CADApplication(factory, shapeBuilderFactory);

        //Shapes
        app.registerShape("Line", LineBuilder.class);
        app.registerShape("Rectangle", RectangleBuilder.class);
        app.registerShape("Node", NodeBuilder.class);

        //Delete
        app.getMouseInputHandler().registerClickPolicy("MOUSE_3", new DeleteCommand(app.getShapeRepository(), app.getCanvasRepaintCommand()));

        //Move Shape or Point (currently only alternative)
        app.getMouseInputHandler().registerDragAndDropPolicy("MOUSE_1", new ShapeMoveCommand(app.getShapeRepository(), app.getCanvasRepaintCommand()));
//        app.getMouseInputHandler().registerDragAndDropPolicy("MOUSE_1", new PointMoveCommand(app.getShapeRepository(), app.getCanvasRepaintCommand()));

        app.run();
    }
}
