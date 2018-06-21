package de.tu_bs.cs.isf.spl.simplecad.core.builder; 

import de.tu_bs.cs.isf.spl.simplecad.core.model.Point; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape; 

public abstract  class  ShapeBuilder {
	

    public abstract void addPoint(Point point);

	
    public abstract boolean isShapeFinished();

	
    public abstract Shape getShape();

	
    protected abstract Shape makeShape();


}
