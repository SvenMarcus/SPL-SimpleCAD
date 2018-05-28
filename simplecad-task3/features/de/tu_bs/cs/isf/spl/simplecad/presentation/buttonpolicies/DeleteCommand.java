package de.tu_bs.cs.isf.spl.simplecad.presentation.buttonpolicies;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.presentation.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRepository;

import java.util.Iterator;

public class DeleteCommand implements ButtonCommand {

    private final ShapeRepository repository;
    private final CanvasRepaintCommand canvasRepaintCommand;

    public DeleteCommand(ShapeRepository repository, CanvasRepaintCommand canvasRepaintCommand) {
        this.repository = repository;
        this.canvasRepaintCommand = canvasRepaintCommand;
    }

    public void execute(int x, int y) {
        Iterator<Shape> it = repository.shapes();
        Shape shapeToDelete = null;
        while (it.hasNext()) {
            Shape shape = it.next();
            if (shape.isPointOnBoundary(new Point(x, y), 10))
                shapeToDelete = shape;
        }

        if (shapeToDelete != null) {
            repository.removeShape(shapeToDelete);
            canvasRepaintCommand.execute();
        }
    }
}
