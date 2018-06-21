package de.tu_bs.cs.isf.spl.simplecad.core.model; 

import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 

public  class  ShapeRepository {
	

    private List<Shape> shapes = new ArrayList<Shape>();

	

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

	

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

	

    public Iterator<Shape> shapes() {
        return shapes.iterator();
    }


}
