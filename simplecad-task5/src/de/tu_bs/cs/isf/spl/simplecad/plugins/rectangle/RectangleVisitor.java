package de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle; 

import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeVisitor; 

public  interface  RectangleVisitor  extends ShapeVisitor {
	
    void visit(Rectangle rectangle);


}
