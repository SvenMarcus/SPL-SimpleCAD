package de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape;

import de.tu_bs.cs.isf.spl.simplecad.core.input.DragAndDropCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

import java.util.Iterator;

public class ShapeMoveCommand implements DragAndDropCommand {

    private final ShapeMover shapeMover;
    private ShapeRepository repository;
    private CanvasRepaintCommand canvasRepaintCommand;
    private Shape shapeToMove;
    private boolean dragging;
    private int firstX, firstY;
    private int dx, dy;

    public ShapeMoveCommand(ShapeRepository repository, CanvasRepaintCommand canvasRepaintCommand) {
        this.repository = repository;
        this.canvasRepaintCommand = canvasRepaintCommand;
        this.shapeMover = new ShapeMover();
    }

    public void drag(int x, int y) {
        if (!dragging) {
            firstX = x;
            firstY = y;
            dragging = true;
            Iterator<Shape> it = repository.shapes();
            while (it.hasNext()) {
                Shape shape = it.next();
                if (shape.isPointOnBoundary(new Point(x, y), 10)) {
                    shapeToMove = shape;
                    break;
                }
            }
        }
        
        dx = x - firstX;
        dy = y - firstY;

        moveShape();
        
        firstX = x;
        firstY = y;
    }
    
    private void moveShape() {
    	if (shapeToMove != null) {
            shapeMover.setMoveDistance(dx, dy);
            shapeToMove.accept(shapeMover);
            canvasRepaintCommand.execute();
        }
    }

    public void drop(int x, int y) {
        dx = 0;
        dy = 0;
        shapeToMove = null;
        dragging = false;
    }
}
