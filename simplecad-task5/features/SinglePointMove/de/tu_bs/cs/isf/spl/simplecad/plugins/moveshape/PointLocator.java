package de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape;


import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeVisitor;
import de.tu_bs.cs.isf.spl.simplecad.plugins.line.*;
import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.*;
import de.tu_bs.cs.isf.spl.simplecad.plugins.node.*;

public class PointLocator implements ShapeVisitor, LineVisitor, RectangleVisitor, NodeVisitor {

	private Point point;
	private Point locatedPoint;
	
	public void setPoint(Point p) {
		this.point = p;
		locatedPoint = null;
	}
	
	public Point getLocatedPoint() {
		return locatedPoint;
	}
	
	public void visit(Line line) {
		if(point.distanceTo(line.getFirst()) < 10)
			locatedPoint = line.getFirst();
		else if(point.distanceTo(line.getSecond()) < 10)
			locatedPoint = line.getSecond();
	}

	public void visit(Rectangle rectangle) {
		if(point.distanceTo(rectangle.getFirst()) < 10)
			locatedPoint = rectangle.getFirst();
		else if(point.distanceTo(rectangle.getSecond()) < 10)
			locatedPoint = rectangle.getSecond();
	}

	public void visit(Node node) {
		if(point.distanceTo(node.getPoint()) < 10)
			locatedPoint = node.getPoint();
	}

}