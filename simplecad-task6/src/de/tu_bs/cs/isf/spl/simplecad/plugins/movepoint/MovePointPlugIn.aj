package de.tu_bs.cs.isf.spl.simplecad.plugins.movepoint;

import java.util.Iterator;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape.MoveShapePlugIn;
import de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape.ShapeMoveCommand;

privileged public aspect MovePointPlugIn {
	
	declare precedence: *, MoveShapePlugIn, MovePointPlugIn;
	
	private PointLocator ShapeMoveCommand.pointLocator = new PointLocator();
    private Point ShapeMoveCommand.pointToMove;
	
	void around(ShapeMoveCommand command, int x, int y) : execution(void ShapeMoveCommand.drag(int,int)) && target(command) && args(x,y) {
		if (!command.dragging) {
			command.firstX = x;
			command.firstY = y;
			command.dragging = true;
            Iterator<Shape> it = command.repository.shapes();
            
            command.pointLocator.setPoint(new Point(x, y));
            
            while (it.hasNext()) {
                Shape shape = it.next();
                
                shape.accept(command.pointLocator);
                if(command.pointLocator.getLocatedPoint() != null) {
                	command.pointToMove = command.pointLocator.getLocatedPoint();
                	break;
                }
                
                if (shape.isPointOnBoundary(new Point(x, y), 10)) {
                	command.shapeToMove = shape;
                    break;
                }
            }
        }
        
		command.dx = x - command.firstX;
		command.dy = y - command.firstY;
        
        if (command.pointToMove != null) {
        	command.pointToMove.setX(command.pointToMove.getX() + command.dx);
        	command.pointToMove.setY(command.pointToMove.getY() + command.dy);
        	command.canvasRepaintCommand.execute();
        }

        command.moveShape();
        
        command.firstX = x;
        command.firstY = y;
	}
	
	void around(ShapeMoveCommand command, int x, int y) : execution(void ShapeMoveCommand.drop(int,int)) && args(x,y) && target(command) {
		proceed(command, x, y);
		command.pointToMove = null;
	}
}
