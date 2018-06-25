package de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape;

import de.tu_bs.cs.isf.spl.simplecad.core.input.DragAndDropCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

import java.util.Iterator;

public class ShapeMoveCommand implements DragAndDropCommand {


    private PointLocator pointLocator;
    private Point pointToMove;
    
    public ShapeMoveCommand(ShapeRepository repository, CanvasRepaintCommand canvasRepaintCommand) {
        this.pointLocator = new PointLocator();
    }

    public void drag(int x, int y) {
        if (!dragging) {
            firstX = x;
            firstY = y;
            dragging = true;
            Iterator<Shape> it = repository.shapes();
            
            pointLocator.setPoint(new Point(x, y));
            
            while (it.hasNext()) {
                Shape shape = it.next();
                
                shape.accept(pointLocator);
                if(pointLocator.getLocatedPoint() != null) {
                	pointToMove = pointLocator.getLocatedPoint();
                	break;
                }
                
                if (shape.isPointOnBoundary(new Point(x, y), 10)) {
                    shapeToMove = shape;
                    break;
                }
            }
        }
        
        dx = x - firstX;
        dy = y - firstY;
        
        if (pointToMove != null) {
        	pointToMove.setX(pointToMove.getX() + dx);
        	pointToMove.setY(pointToMove.getY() + dy);
        	canvasRepaintCommand.execute();
        }

        moveShape();
        
        firstX = x;
        firstY = y;
    }

    public void drop(int x, int y) {
    	original(x, y);
        pointToMove = null;
    }
}
