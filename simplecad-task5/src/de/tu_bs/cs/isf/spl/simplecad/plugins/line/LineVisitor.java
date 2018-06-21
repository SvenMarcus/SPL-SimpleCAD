package de.tu_bs.cs.isf.spl.simplecad.plugins.line; 

import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeVisitor; 

public  interface  LineVisitor  extends ShapeVisitor {
	
    void visit(Line line);


}
