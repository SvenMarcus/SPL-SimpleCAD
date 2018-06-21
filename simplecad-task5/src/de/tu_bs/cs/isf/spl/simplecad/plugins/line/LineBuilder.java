package de.tu_bs.cs.isf.spl.simplecad.plugins.line; 

import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape; 

public  class  LineBuilder  extends ShapeBuilder {
	
    private int pointsAdded;

	
    private Line line;

	

    public void addPoint(Point point) {
        pointsAdded++;
        if (line == null)
            line = (Line) makeShape();
        if (pointsAdded == 1)
            line.setFirst(point);
        else if (pointsAdded == 2)
            line.setSecond(point);
    }

	

    public boolean isShapeFinished() {
        return pointsAdded > 1;
    }

	

    public Shape getShape() {
        if (line == null)
            line = (Line) makeShape();
        return line;
    }

	

    protected Shape makeShape() {
        return new Line();
    }


}
