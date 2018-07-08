package de.tu_bs.cs.isf.spl.simplecad.plugins.movepoint;

import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.plugins.line.Line;
import de.tu_bs.cs.isf.spl.simplecad.plugins.line.LineVisitor;
import de.tu_bs.cs.isf.spl.simplecad.plugins.node.Node;
import de.tu_bs.cs.isf.spl.simplecad.plugins.node.NodeVisitor;
import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.Rectangle;
import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.RectangleVisitor;

public class PointMover implements LineVisitor, RectangleVisitor, NodeVisitor {

    private int dx;
    private int dy;
    private Point origin;
    private boolean moved;


    public void setOrigin(int x, int y) {
        origin = new Point(x, y);
        moved = false;
    }

    public void setMoveDistance(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        moved = false;
    }

    public boolean movedPoint() {
        return moved;
    }

    public void visit(Line line) {
        Point point = line.getFirst();
        if (point.distanceTo(origin) <= 10) {
            line.setFirst(new Point(point.getX() + dx, point.getY() + dy));
            moved = true;
            return;
        }

        point = line.getSecond();
        if (point.distanceTo(origin) <= 10) {
            line.setSecond(new Point(point.getX() + dx, point.getY() + dy));
            moved = true;
        }
    }

    public void visit(Node node) {
        Point point = node.getPoint();
        if (point.distanceTo(origin) <= 10) {
            node.setPoint(new Point(point.getX() + dx, point.getY() + dy));
            moved = true;
        }
    }

    public void visit(Rectangle rectangle) {
        Point point = rectangle.getFirst();
        if (point.distanceTo(origin) <= 10) {
            rectangle.setFirst(new Point(point.getX() + dx, point.getY() + dy));
            moved = true;
            return;
        }

        point = rectangle.getSecond();
        if (point.distanceTo(origin) <= 10) {
            rectangle.setSecond(new Point(point.getX() + dx, point.getY() + dy));
            moved = true;
        }
    }
}
