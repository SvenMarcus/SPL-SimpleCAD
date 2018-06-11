package de.tu_bs.cs.isf.spl.simplecad.plugins.movepoint;

import de.tu_bs.cs.isf.spl.simplecad.core.input.DragAndDropCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;
import de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape.ShapeMover;

import java.util.Iterator;

public class PointMoveCommand implements DragAndDropCommand {

    private final PointMover pointMover;
    private ShapeRepository repository;
    private CanvasRepaintCommand canvasRepaintCommand;
    private boolean dragging;
    private int firstX, firstY;
    private int dx, dy;

    public PointMoveCommand(ShapeRepository repository, CanvasRepaintCommand canvasRepaintCommand) {
        this.repository = repository;
        this.canvasRepaintCommand = canvasRepaintCommand;
        pointMover = new PointMover();
    }


    public void drag(int x, int y) {
        if (!dragging) {
            firstX = x;
            firstY = y;
            dragging = true;
        }

        pointMover.setOrigin(x, y);
        dx = x - firstX;
        dy = y - firstY;

        pointMover.setMoveDistance(dx, dy);

        Iterator<Shape> it = repository.shapes();
        while (it.hasNext()) {
            Shape shape = it.next();
            shape.accept(pointMover);
            if (pointMover.movedPoint()) {
                canvasRepaintCommand.execute();
                break;
            }
        }

        firstX = x;
        firstY = y;

    }

    public void drop(int x, int y) {
        dx = 0;
        dy = 0;
        dragging = false;
    }
}
