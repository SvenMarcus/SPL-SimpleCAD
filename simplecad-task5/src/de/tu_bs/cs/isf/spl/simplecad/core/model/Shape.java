package de.tu_bs.cs.isf.spl.simplecad.core.model; 

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ShapeRenderer; 

public  interface  Shape {
	
    boolean isPointOnBoundary(Point point, int radius);

	

    void render(ShapeRenderer renderer);

	

    boolean accept(ShapeVisitor visitor);


}
