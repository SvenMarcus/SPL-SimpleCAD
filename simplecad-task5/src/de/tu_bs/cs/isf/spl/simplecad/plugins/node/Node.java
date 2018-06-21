package de.tu_bs.cs.isf.spl.simplecad.plugins.node; 


import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ShapeRenderer; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeVisitor; 

public  class  Node  implements Shape {
	

    private Point point;

	

    public void setPoint(Point point) {
        this.point = point;
    }

	

    public Point getPoint() {
        return point;
    }

	

    public boolean isPointOnBoundary(Point point, int radius) {
        return this.point.distanceTo(point) <= radius;
    }

	

    public void render(ShapeRenderer renderer) {
        renderer.renderNode(point.getX(), point.getY());
    }

	

    public boolean accept(ShapeVisitor visitor) {
        try {
            NodeVisitor v = (NodeVisitor) visitor;
            v.visit(this);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }


}
